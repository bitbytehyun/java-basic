package core.generic.basic;

import java.util.List;

public class Generic {
    public void execute() {
        // class generic
        ApiResponse<String> response = new ApiResponse<>(true, "성공", "DTO");
        PageResult<String> page = new PageResult<>(0, 10, 100, List.of("hi"));

        // method generic
        Printer.print("Hello");
        Printer.print(1.2);
        String[] names = {"shu", "seohyun"};
        ArrayUtils.printArray(names);

        // class generic with 2 types
        Pair<Integer, String> pair = new Pair<>(1, "shu");
        System.out.println(pair.getKey() + ": " + pair.getValue());
    }

    public class ApiResponse<T> {
        private boolean success;
        private String message;
        private T data;

        public ApiResponse(
                boolean success, String message, T data
        ) {
            this.success = success;
            this.message = message;
            this.data = data;
        }
    }

    public class PageResult<T> {
        private int page;
        private int size;
        private long totalElement;
        private List<T> contents;

        public PageResult(
                int page, int size, int totalElement, List<T> contents
        ) {
            this.page = page;
            this.size = size;
            this.totalElement = totalElement;
            this.contents = contents;
        }
    }

    public class Printer {
        public static <T> void print(T data) {
            System.out.println(data);
        }
    }

    public class ArrayUtils {
        public static <T> void printArray(T[] array) {
            for (T element : array) {
                System.out.println(element);
            }
        }
    }

    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
