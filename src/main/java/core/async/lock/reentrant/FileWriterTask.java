package core.async.lock.reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class FileWriterTask implements Runnable {
    private final ReentrantLock lock;

    public FileWriterTask(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(500, TimeUnit.MILLISECONDS)) { // 락이 걸리는 시점. 데드락 가능성이 있는 환경에서 활용
                try {
                    System.out.println(Thread.currentThread().getName() + " is writing file...");
                    Thread.sleep(300);
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to get lock...");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
