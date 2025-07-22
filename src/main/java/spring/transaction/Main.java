package spring.transaction;

public class Main {
    public static void main(String[] args) {
        SimpleTransactionManager txManager = new SimpleTransactionManager();
        TransactionAttribute txAttr = new TransactionAttribute(Propagation.REQUIRED);

    }
}
