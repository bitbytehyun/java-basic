package spring.transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionalProxy implements InvocationHandler {

    private final Object target;
    private final TransactionAttribute txAttr;
    private final SimpleTransactionManager txManager;

    public TransactionalProxy(Object target, TransactionAttribute txAttr, SimpleTransactionManager txManager) {
        this.target = target;
        this.txAttr = txAttr;
        this.txManager = txManager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean newTx = false;
        String suspendedTx = null;

        if (txAttr.getPropagation() == Propagation.REQUIRES_NEW) {
            if (txManager.hasTransaction()) {
                suspendedTx = txManager.currentTransaction();
                txManager.suspend();
            }
            txManager.begin();
            newTx = true;
        } else if (txAttr.getPropagation() == Propagation.REQUIRED) {
            if (!txManager.hasTransaction()) {
                txManager.begin();
                newTx = true;
            }
        }
        try {
            Object result = method.invoke(target, args);
            if (newTx) txManager.commit();
            return result;
        } catch (Exception e) {
            if (newTx) txManager.rollback();
            throw e;
        } finally {
            if (suspendedTx != null) {
                txManager.resume(suspendedTx);
            }
        }
    }
}
