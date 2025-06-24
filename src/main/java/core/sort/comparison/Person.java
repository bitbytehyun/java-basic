package core.sort.comparison;

public class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 나이와 이름 순으로 정렬
    @Override
    public int compareTo(Person o) {
        int ageCompare = Integer.compare(this.age, o.age);
        return ageCompare != 0 ? ageCompare : this.name.compareTo(o.name);
    }
}
