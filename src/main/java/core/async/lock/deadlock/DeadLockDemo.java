package core.async.lock.deadlock;

public class DeadLockDemo {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("method1");
            }
        }
    }

    public void method2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("method2");
            }
        }
    }
}
