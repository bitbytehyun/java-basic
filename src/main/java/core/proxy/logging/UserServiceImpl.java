package core.proxy.logging;

public class UserServiceImpl implements UserService {
    @Override
    public void createUser() {
        System.out.println("사용자 계정 생성 로직 실행");
    }
}
