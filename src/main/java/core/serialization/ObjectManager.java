package core.serialization;

import java.io.*;

public class ObjectManager {

    public void save(Person person) throws IOException { // 직렬화
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
        oos.writeObject(person);
        oos.close();

        System.out.println("person.ser 파일로 저장 완료");
    }

    public void load() throws IOException, ClassNotFoundException { // 역직렬화
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));
        Person p = (Person) ois.readObject();
        ois.close();

        System.out.println("이름: " + p.name);
        System.out.println("나이: " + p.age);
    }


    public class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

