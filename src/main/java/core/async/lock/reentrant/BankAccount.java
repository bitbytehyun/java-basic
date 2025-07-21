package core.async.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private final ReentrantLock lock = new ReentrantLock();
    private int balance = 0;

    public void withdraw(int amount) {
        lock.lock();
        try {
            // 복잡한 흐름이 섞이면 synchronized 보다 lock()/unlock()이 직접 관리하여 더 안정적이다.
            if (balance >= amount) {
                Thread.sleep(1000); // 지연 시점
                balance -= amount;
                System.out.println("withdrawn: " + amount + ", remaining: " + balance);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
