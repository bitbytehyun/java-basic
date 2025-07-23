package architecture.hexagonal.application.port.in;

import architecture.hexagonal.application.port.in.command.PlaceOrderCommand;

public interface PlaceOrderUseCase {
    Long placeOrder(PlaceOrderCommand command);
}
