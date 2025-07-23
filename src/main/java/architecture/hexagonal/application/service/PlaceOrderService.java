package architecture.hexagonal.application.service;

import architecture.hexagonal.application.port.in.PlaceOrderUseCase;
import architecture.hexagonal.application.port.in.command.PlaceOrderCommand;
import architecture.hexagonal.application.port.out.CheckStockPort;
import architecture.hexagonal.application.port.out.LoadProductPort;
import architecture.hexagonal.application.port.out.SaveOrderPort;
import architecture.hexagonal.domain.model.Order;
import org.springframework.stereotype.Service;

@Service
public class PlaceOrderService implements PlaceOrderUseCase {
    private final LoadProductPort loadProductPort;
    private final CheckStockPort checkStockPort;
    private final SaveOrderPort saveOrderPort;

    public PlaceOrderService(LoadProductPort loadProductPort, CheckStockPort checkStockPort, SaveOrderPort saveOrderPort) {
        this.loadProductPort = loadProductPort;
        this.checkStockPort = checkStockPort;
        this.saveOrderPort = saveOrderPort;
    }

    @Override
    public Long placeOrder(PlaceOrderCommand command) {
        int price = loadProductPort.getPrice(command.productId());
        boolean available = checkStockPort.hasStock(command.productId(), command.quantity());

        if (!available) {
            throw new RuntimeException("Out of stock");
        }

        Order order = Order.create(command.customerId(), command.productId(), command.quantity(), price);
        Order saved = saveOrderPort.save(order);
        return saved.getId();
    }
}
