package core.stream.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {

    private List<T> source;
    private List<Function<Object, Object>> operations = new ArrayList<>();

    public MyStream(List<T> source) {
        this.source = source;
    }

    public static <T> MyStream<T> of(List<T> source) {
        return new MyStream<>(source);
    }

    // 중간 연산
    public <R> MyStream<R> map(Function<? super T, ? extends R> mapper) {
        operations.add(obj -> mapper.apply((T) obj));
        return (MyStream<R>) this;
    }

    public MyStream<T> filter(Predicate<? super T> predicate) {
        operations.add(obj -> predicate.test((T) obj) ? obj : null);
        return this;
    }

    public List<T> collect() {
        List<T> result = new ArrayList<>();
        for (T item : source) {
            Object current = item;
            for (Function<Object, Object> operation : operations) {
                current = operation.apply(current);
                if (current == null) break;
            }
            if (current != null) {
                result.add((T) current);
            }
        }
        return result;
    }
}
