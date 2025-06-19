package core;

import java.util.List;

public class GenericWildcardExtend {

    public void readAnimals(List<? extends Animal> list) { // List<Animal 이하의 하위타입>
        Animal animal = list.get(0); //Object 대신 Animal 타입 가능하다. (상향 제한)
    }

    public void writeAnimals(List<? super Dog> list) { // List<Dog 이상의 상위타입>
        list.add(new Dog());
        list.add(new Puppy());
    }


    public class Animal {
    }

    public class Dog extends Animal {
    }

    public class Puppy extends Dog {
    }


    // 응용: 읽기 전용 매서드 설계
    public double getSum(List<? extends Number> list) {
        double total = 0;
        for (Number number : list) { // 여기서 Object 대신 Number
            total += number.doubleValue();
        }
        return total;
    }

    // 응용: 쓰기 전용 매서드 설계
    public void addInteger(List<? super Integer> list) {
        list.add(10);
    }

    // 활용: 배열 객체 복사 (
    public static <T> void copyArray(List<? super T> dest, List<? extends T> src) {
        for (T item : src) {
            dest.add(item);
        }
    }
}
