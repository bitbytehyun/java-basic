package core.async.lock.synchro;

public class Logger {
    // 동기화 사유 : 여러 쓰레드가 동시에 로그 파일에 접근하면 파일 내용이 꺠질 수 있음
    public synchronized void log(String message) {
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }
}
