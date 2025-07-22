package core.proxy.reflect.aop;

import java.lang.reflect.Proxy;

public class ProxyExample {
    public static void main(String[] args) {
        Calculator real = new CalculatorImpl();

        Calculator proxy = (Calculator) Proxy.newProxyInstance(
                Calculator.class.getClassLoader(),
                new Class[]{Calculator.class},
                new CalculatorInvocationHandler(real)
        );

        int sum = proxy.add(1, 2);
        System.out.println("결과 : " + sum);

        int diff = proxy.subtract(1, 2);
        System.out.println("결과 : " + diff);
    }
}
