package core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda {
    private void implementRunnable() {
        // 예시 1. 쓰레드 실행
        new Thread(() -> System.out.println("쓰레드 실행")).start();

        // 예시 2. 스케줄러 작업 등록
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println("예약 작업"), 1, TimeUnit.SECONDS);
    }

    private void implementComparator() {
        // 예시 1. 문자열 길이로 정렬
        List<String> list = new ArrayList<>();
        list.sort((a, b) -> a.length() - b.length());

        // 예시 2. 날짜 내림차순
        List<Event> events = new ArrayList<>();
        events.sort((e1, e2) -> e2.getDate().compareTo(e1.getDate()));
    }

    private void implementPredicate() {
        // 예시 1. 문자열 비어있는 지 조건
        Predicate<String> isEmpty = s -> s.isEmpty();

        // 예시 2. 짝수 조건
        List<Integer> list = new ArrayList<>();
        Predicate<Integer> isEven = n -> n % 2 == 0;
        list.stream().filter(isEven).forEach(System.out::println);
    }

    private void implementConsumer() { // 입력 -> void
        // 예시 1. 입력 출력
        Consumer<String> printer = s -> System.out.println(s);

        // 예시 2. 리스트 요소 출력
        List<String> list = new ArrayList<>();
        list.forEach(printer);
    }

    private void implementFunction() { // 입력 -> (변환) -> 반환
        // 예시 1. 문자열 길이 구하기
        Function<String, Integer> length = s -> s.length();

        // 예시 2. 이벤트 -> 날짜
        Function<Event, LocalDate> getDate = e -> e.getDate();
    }

    private void implementSupplier() { // () -> 반환
        // 예시 1. 현재 시간 반환
        Supplier<LocalDateTime> now = () -> LocalDateTime.now();

        // 예시 2. 기본값 반환
        Supplier<String> defaultName = () -> "guest";

        // 예시 3. 임시 ID 생성
        Supplier<UUID> idGenerator = () -> UUID.randomUUID();
    }


    public class Event {
        public LocalDate date;

        public LocalDate getDate() {
            return date;
        }
    }

}
