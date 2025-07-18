package core.proxy;

public class ServiceProxy implements Service {
    private RealService realService; // 필드

    public void execute() {

        // before
        System.out.println("로깅 : Service 실행 전");

        // 실제 실행
        if (realService == null) {
            realService = new RealService();
        }
        realService.execute();

        //after
        System.out.println("로깅 : Service 실행 후");
    }
}
