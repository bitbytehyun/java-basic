package core.enumerate;

public class Day {

    public static final Day MONDAY = new Day("MONDAY", 0);
    public static final Day TUESDAY = new Day("TUESDAY", 1);
    public static final Day WEDNESDAY = new Day("WEDNESDAY", 2);
    public static final Day THURSDAY = new Day("THURSDAY", 3);
    public static final Day FRIDAY = new Day("FRIDAY", 4);
    public static final Day SATURDAY = new Day("SATURDAY", 5);
    public static final Day SUNDAY = new Day("SUNDAY", 6);

    private final String name;
    private final int ordinal;

    private Day(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public String name() {
        return name;
    }

    public int ordinal() {
        return ordinal;
    }

    public static Day[] values() {
        return VALUES.clone();
    }

    private static final Day[] VALUES = new Day[]{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
}


// public enum class Day { MONDAY, TUESDAY, .. } 와 동일