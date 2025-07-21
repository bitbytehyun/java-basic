package core.async.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureEx {
    public void doSimpleAsync() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            try {
                Thread.sleep(10000); // 외부 api 호출
                return "응답 완료";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("결과: " + future.get()); // 10초 후 출력
        executor.shutdown();
    }

    public void doParallelAsync() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = Arrays.asList(
                () -> "User Info",
                () -> "Weather Info",
                () -> "Notification Count"
        );

        List<Future<String>> futures = executor.invokeAll(tasks);
        for (Future<String> future : futures) {
            System.out.println("응답: " + future.get());
        }
        executor.shutdown();
    }

    public void doParallelAsyncWithFastestOne() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = Arrays.asList(
                () -> {
                    Thread.sleep(1000);
                    return "User Info";

                },
                () -> {

                    Thread.sleep(2000);
                    return "Weather Info";
                },
                () -> {
                    Thread.sleep(3000);
                    return "Notification Count";
                }
        );
        String result = executor.invokeAny(tasks);
        System.out.println("가장 빠른 결과 : " + result);
        executor.shutdown();
    }

    public void doParallelAsyncTasks() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<String> dbFuture = executor.submit(() -> {
            return "fetch user list from db";
        });
        Future<String> imageFuture = executor.submit(() -> {
            return "resize image";
        });
        dbFuture.get();
        imageFuture.get();

        executor.shutdown();

    }

    public void doSimpleAsyncWithTimeout() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(3000);
            return 100;
        });
        try {
            Integer result = future.get(1, TimeUnit.SECONDS);
            System.out.println("결과: " + result);
        } catch (TimeoutException e) {
            System.out.println("시간 초과로 실패");
        }
        executor.shutdown();
    }

    public void doSimpleAsyncWithoutResult() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            System.out.println("로그 저장 중...");
        });
        future.get();
        executor.shutdown();
    }

    public static void main(String[] args) {
        FutureEx futureEx = new FutureEx();
        try {
//            futureEx.doSimpleAsync();
//            futureEx.doParallelAsync();
            futureEx.doSimpleAsyncWithTimeout();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
