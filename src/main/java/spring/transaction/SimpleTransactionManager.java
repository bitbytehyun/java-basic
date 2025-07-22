package spring.transaction;

public class SimpleTransactionManager {
    private static final ThreadLocal<String> currentTx = new ThreadLocal<>();

    public void begin() {
        currentTx.set("TX-" + System.nanoTime());
        System.out.println("트랜젝션 시작");
    }

    public void commit() {
        System.out.println("트랜젝션 커밋");
        currentTx.remove();
    }

    public void rollback() {
        System.out.println("트랜젝션 롤백");
        currentTx.remove();
    }

    public boolean hasTransaction() {
        return currentTx.get() != null;
    }

    public void suspend() {
        System.out.println("기존 트랜젝션 일시정지: " + currentTx.get());
        currentTx.remove();
    }

    public void resume(String tx) {
        currentTx.set(tx);
        System.out.println("트랜젝션 재게: " + tx);
    }

    public String currentTransaction() {
        return currentTx.get();
    }
}
