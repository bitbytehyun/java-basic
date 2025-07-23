package architecture.hexagonal.application.port.out;

public interface CheckStockPort {
    boolean hasStock(Long productId, int quantity);
}
