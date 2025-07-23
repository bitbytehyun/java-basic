package architecture.hexagonal.adapter.out.persistence.mapper;

import architecture.hexagonal.adapter.out.persistence.OrderJpaEntity;
import architecture.hexagonal.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderJpaEntity toJpaEntity(Order order) {
        return new OrderJpaEntity();
    }

    public Order toDomain(OrderJpaEntity saved) {
        return null;
    }
}
