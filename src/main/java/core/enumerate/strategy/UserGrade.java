package core.enumerate.strategy;

import java.util.function.DoubleUnaryOperator;

public enum UserGrade {
    BRONZE(grade -> grade * 0.99),
    SILVER(grade -> grade * 0.95),
    GOLD(grade -> grade * 0.9),
    // 여기에만 등급 추가시 추가 작성하면 됨
    ;

    private final DoubleUnaryOperator operator;

    UserGrade(DoubleUnaryOperator operator) {
        this.operator = operator;
    }

    public double applyDiscount(double price) {
        return this.operator.applyAsDouble(price);
    }
}
