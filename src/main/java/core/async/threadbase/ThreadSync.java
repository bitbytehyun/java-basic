package core.async.threadbase;

public class ThreadSync {
    public static void main(String[] args) throws InterruptedException {
        // main 스레드 시작
        syncPrintAfterDelay("메세지입니다.", 2000);
        System.out.println("main thread ends");
    }

    public static void syncPrintAfterDelay(String message, long delayMillis) throws InterruptedException {
        Thread.sleep(delayMillis);
        System.out.println(message);
    }
}
