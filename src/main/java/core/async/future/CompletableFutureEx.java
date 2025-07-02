package core.async.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureEx {
    public void doSimpleAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "db 결과 조회";
        });
        System.out.println(cf.get());
    }

    public void applyResult() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "user123")
                .thenApply(id -> "user info: " + id);  // 의미 : 비동기 콜백까지 가능
        System.out.println(cf.get());
    }

    public void acceptResult() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> "event log")
                .thenAccept(log -> System.out.println("log: " + log));
        System.out.println(cf.get());
    }

    public void combineResults() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "user123")
                .thenCompose(id -> CompletableFuture.supplyAsync(() -> "user info: " + id));
        System.out.println(cf.get());
    }

    public void combineParallelResults() throws ExecutionException, InterruptedException {
        CompletableFuture<String> idFuture = CompletableFuture.supplyAsync(() -> "user123");
        CompletableFuture<Integer> ageFuture = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<String> result = idFuture.thenCombine(ageFuture, (id, age) -> "user info: " + id + ", age: " + age);
        System.out.println(result.get());
    }

    public void handleException() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("fail");
            }
            return "OK";
        }).exceptionally(e -> "default");

        System.out.println(cf.get());
    }

    public void waitAllFuture() {
        CompletableFuture<String> a = CompletableFuture.supplyAsync(() -> "a");
        CompletableFuture<String> b = CompletableFuture.supplyAsync(() -> "b");

        CompletableFuture<Void> all = CompletableFuture.allOf(a, b);
        all.join();
        System.out.println("all done");
    }

    public void getAnyFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> naver = CompletableFuture.supplyAsync(() -> "naver responded");
        CompletableFuture<String> google = CompletableFuture.supplyAsync(() -> "google responded");

        CompletableFuture<Object> fastest = CompletableFuture.anyOf(naver, google);
        System.out.println("가장 빠른 결과: " + fastest.get());
    }

    public void simpleAsyncCustomPool() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            return "task 1";
        }, executor).thenApply(result -> {
            return result + " -> apply(가공)";
        });
        System.out.println(cf.get());
        executor.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureEx ex = new CompletableFutureEx();
//        ex.doSimpleAsync();
//        ex.applyResult();
//        ex.acceptResult();
        ex.combineResults();
        ex.combineParallelResults();
        ex.handleException();
        ex.waitAllFuture();
        ex.getAnyFuture();
        ex.simpleAsyncCustomPool();
    }
}
