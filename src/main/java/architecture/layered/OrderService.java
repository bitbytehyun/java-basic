package architecture.layered;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Long createOrder(OrderDto dto) {
        Order order = new Order(
                dto.getId(),
                dto.getCustomerName(),
                dto.getProductName(),
                dto.getQuantity(),
                dto.getTotalPrice()
        );
        orderRepository.save(order);
        return order.getId();

    }
}
