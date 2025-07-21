package core.async.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockEx {
    // 먼저 락
    ReentrantLock fairLock = new ReentrantLock(true); // FIFO 순서로 락 배분

    public void accessResource() {
        fairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " accesses resource...");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            fairLock.unlock();
        }
    }
}
