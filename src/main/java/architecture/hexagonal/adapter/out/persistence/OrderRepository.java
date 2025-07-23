package architecture.hexagonal.adapter.out.persistence;

import architecture.hexagonal.adapter.out.persistence.mapper.OrderMapper;
import architecture.hexagonal.application.port.out.SaveOrderPort;
import architecture.hexagonal.domain.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository implements SaveOrderPort {
    private final OrderJpaRepository repo;
    private final OrderMapper mapper;

    public OrderRepository(OrderJpaRepository repo, OrderMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;

    }

    @Override
    public Order save(Order order) {
        OrderJpaEntity entity = mapper.toJpaEntity(order);
        OrderJpaEntity saved = repo.save(entity);

        return mapper.toDomain(saved);
    }

}
