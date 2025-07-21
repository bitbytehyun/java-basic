package core.async.threadbase;

public class ThreadState {

    public static void join() throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker thread starts");
            try {
                Thread.sleep(2000); // [WORKER] 2. TIME_WAITING
            } catch (InterruptedException e) {
            }
            System.out.println("Worker thread ends"); // [WORKER] 3. TERMINATED

        });
        worker.start(); // [WORKER] 1. RUNNABLE

        // [MAIN] 1. RUNNABLE
        System.out.println("main thread: join starts (wait for worker thread to finish)");
        worker.join(); // [MAIN] 2. WAITING
        System.out.println("main thread: join ends"); // [MAIN] 3. RUNNABLE
    }

    public static void waitAndNotify() {
        Object lock = new Object();

        Thread waiter = new Thread(() -> {
            synchronized (lock) { // [WAITER] 2. lock 획득
                System.out.println("Waiter: waiting...");
                try {
                    lock.wait(); // [WAITER] 3. WAITING, [NOTIFIER] 5. RUNNABLE, (의미) 락을 반환하고 waiting 상태로 전환한다.
                } catch (InterruptedException e) {
                }
                System.out.println("Waiter: awake!"); // [WAITER] 9. RUNNABLE & TERMINATED
            }
        });

        Thread notifier = new Thread(() -> {
            try {
                Thread.sleep(1000); // [NOTIFIER] 6. TIME_WAITING
            } catch (InterruptedException e) {
            }
            synchronized (lock) {
                System.out.println("Notifier: notifying...");
                lock.notify(); // [WAITER] 7. BLOCKED, (의미) waiting 리스트 중 하나의 스레드를 꺠운다.
            } // [NOTIFIER] 8. TERMINATED
        });
        waiter.start(); // [WAITER] 1. NEW & RUNNABLE
        notifier.start(); // [NOTIFIER] 4. NEW & RUNNABLE
    }


    public static void main(String[] args) throws InterruptedException {
//        join();
        waitAndNotify();
    }

}

