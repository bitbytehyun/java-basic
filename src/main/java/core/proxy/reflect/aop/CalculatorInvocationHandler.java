package core.proxy.reflect.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorInvocationHandler implements InvocationHandler {
    private Object target;

    public CalculatorInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[Before] 매서드 호출 전: " + method.getName());

        Object result = method.invoke(target, args);

        System.out.println("[After] 매서드 호출 후: " + method.getName());
        return result;
    }
}
