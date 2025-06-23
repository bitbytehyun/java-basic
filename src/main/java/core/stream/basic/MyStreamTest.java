package core.stream.basic;

import java.util.Arrays;
import java.util.List;

public class MyStreamTest {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("apple", "banana", "orange");
        List<String> result = MyStream.of(data)
                .filter(s -> s.startsWith("a"))
                .map(s -> s.toUpperCase())
                .collect();

        System.out.println(result);
    }
}
