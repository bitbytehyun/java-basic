package core.proxy.reflect.mapper;

import java.lang.reflect.Proxy;

public class RepoEx {
    public static void main(String[] args) {
        UserRepository repo = (UserRepository) Proxy.newProxyInstance(
                UserRepository.class.getClassLoader(),
                new Class[]{UserRepository.class},
                new RepositoryProxyHandler(UserRepository.class)
        ); // UserRepository 인터페이스를 구현하는 익명의 프록시 클래스를 의미

        User user = repo.findById(1L); // proxy의 invoke() 실행됨
        System.out.println("조회된 사용자: " + user);
        System.out.println(repo.getClass());
    }
}
