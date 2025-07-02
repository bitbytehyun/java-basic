package core.async.future;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class NonblockingEx {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(">>> 비동기 작업 완료");
        });
        System.out.println(">>> main thread does not stopped");


        NonblockingEx nonblockingEx = new NonblockingEx();
        nonblockingEx.chainNonblocking();
        Thread.sleep(10000);
    }


    public void chainNonblocking() {
        CompletableFuture.supplyAsync(() -> { // 새로운 스레드에서
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "step1 complete";
        }).thenApply(result -> {
            System.out.println(result);
            return "step2 complete";
        }).thenAccept(System.out::println);

        System.out.println("main thread ends earlier than step1 and step2");
    }
}
