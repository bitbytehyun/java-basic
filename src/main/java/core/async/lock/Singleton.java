package core.async.lock;

public class Singleton {
    private static Singleton instance = new Singleton();

    // 동기화 사유 : 하나의 인스턴스만 생성하도록 (단, 호출떄마다 락을 획등하기 떄문에 락 경합으로 성능 저하 원인)
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static Singleton getInstanceImproved() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
