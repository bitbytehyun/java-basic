package core.enumerate.strategy;

public class PriceCalculator {
    public double calculatePrice(Grade grade, double price) {
        return switch (grade) {
            case BRONZE -> price * 0.99;
            case SILVER -> price * 0.95;
            case GOLD -> price * 0.90;
        };
    }
}
