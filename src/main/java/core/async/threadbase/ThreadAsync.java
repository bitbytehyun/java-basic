package core.async.threadbase;

public class ThreadAsync {
    public static void main(String[] args) {
        // main 쓰레드 시작
        asyncPrintAfterDelay("출력합니다.", 2000, msg -> {
            System.out.println("비동기 작업 완료 후 불러지는 콜백입니다.");
        });
        System.out.println("main thread ends");
    }

    public static void asyncPrintAfterDelay(String message, long delayMillis, Callback callback) {
        Thread t = new Thread(() -> {
            try {
                // 실제 동작
                Thread.sleep(delayMillis);
                System.out.println(message);

                // 콜백
                callback.onComplete("비동기 성공!");
            } catch (InterruptedException e) {
                callback.onComplete("비동기 실패!");
            }
        });
        t.start();
    }

    interface Callback {
        void onComplete(String msg);
    }
}

