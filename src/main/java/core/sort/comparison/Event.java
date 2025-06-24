package core.sort.comparison;

import java.time.LocalDate;

public class Event implements Comparable<Event> {
    LocalDate date;

    public Event(LocalDate date) {
        this.date = date;
    }

    // 날짜 기준으로 정렬
    @Override
    public int compareTo(Event o) {
        return this.date.compareTo(o.date);
    }
}
