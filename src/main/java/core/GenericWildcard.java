package core;

import java.util.List;

public class GenericWildcard {
    // 타입 안정성과는 거리가 먼 wildcard. Object로 받아서 읽기에만 사용한다.
    public void printWildcard(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
//        list.add("hi"); // 어떤 타입일 지 컴파일러가 몰라서 컴파일 타임에 막힘
    }

    public <T> void printGeneric(List<T> list) {
        for (T item : list) {
            System.out.println(item);
        }
        list.add(list.get(0));
    }


    public Object getFirstWildcard(List<?> list) {
        return list.get(0);
    }

    public <T> T getFirstGeneric(List<T> list) {
        return list.get(0);
    }


    // 와일드카드 extends, super 기본
    public void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n.doubleValue());
        }
    }

    public void addIntegers(List<? super Integer> list) {
        list.add(10); // super은 쓰기 가능
    }

}
