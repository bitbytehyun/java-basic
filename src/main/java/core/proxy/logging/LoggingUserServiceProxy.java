package core.proxy.logging;

public class LoggingUserServiceProxy implements UserService {
    private final UserService target; // 생성자

    public LoggingUserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void createUser() {
        long start = System.currentTimeMillis();

        System.out.println("실행 전");
        target.createUser();
        System.out.println("실행 후");

        long end = System.currentTimeMillis();
        System.out.println("걸린 시간: " + (end - start) + "ms");
    }
}
// client 코드
// UserService target = new UserServiceImpl();
// UserService proxy = new LoggingUserServiceProxy(target);
// proxy.createUser();