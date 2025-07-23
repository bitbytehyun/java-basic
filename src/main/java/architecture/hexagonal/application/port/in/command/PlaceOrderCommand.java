package architecture.hexagonal.application.port.in.command;

public record PlaceOrderCommand(
        Long customerId,
        Long productId,
        int quantity
) {
}
