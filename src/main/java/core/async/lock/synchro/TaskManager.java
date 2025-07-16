package core.async.lock.synchro;

public class TaskManager {

    // 동기화 사유 : 쓰레드 풀 내에서 작업을 병렬이 아니라 순차로 진행하고 싶을 떄
    public synchronized void executeTask(Runnable task) {
        System.out.println("작업 시작");
        try {
            Thread.sleep(2000); // 가상 작업
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("작업 종료");
    }
}
