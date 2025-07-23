package architecture.hexagonal.application.port.out;

public interface LoadProductPort {
    int getPrice(Long productId);
}
