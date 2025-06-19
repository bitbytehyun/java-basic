package core.generic;

import java.util.ArrayList;
import java.util.List;

public class FilterProcessor<T> {
    public void execute() {
        Filter<String> trimFilter = s -> s.trim();
        Filter<String> upperFilter = s -> s.toUpperCase();

        FilterProcessor<String> processor = new FilterProcessor<>();
        processor.addFilter(trimFilter);
        processor.addFilter(upperFilter);

        String result = processor.applyAll("   hello  ");
        System.out.println(result); // "HELLO"
    }


    private final List<Filter<T>> filters = new ArrayList<>();

    // WRITE
    public void addFilter(Filter<T> filter) {
        filters.add(filter);
    }

    // READ
    public T applyAll(T input) {
        T result = input;
        for (Filter<T> filter : filters) {
            result = filter.apply(result);
        }
        return result;
    }

    interface Filter<T> { // 함수형 인터페이스
        T apply(T input);
    }
}
