package architecture.hexagonal.application.port.out;

import architecture.hexagonal.domain.model.Order;

public interface SaveOrderPort {
    Order save(Order order);
}
