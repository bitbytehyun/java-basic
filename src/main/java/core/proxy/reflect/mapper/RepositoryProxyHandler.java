package core.proxy.reflect.mapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RepositoryProxyHandler implements InvocationHandler {
    private Class<?> repositoryInterface;

    public RepositoryProxyHandler(Class<?> repositoryInterface) {
        this.repositoryInterface = repositoryInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[로그] 호출된 매서드: " + method.getName());
        System.out.println("[로그] 파라미터: " + args[0]);

        // 실제 구현 내용
        if (method.getName().equals("findById")) {
            long id = (long) args[0];
            return new User(id, "hi");
        }

        return null;
    }
}
