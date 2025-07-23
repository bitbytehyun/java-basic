package architecture.hexagonal.adapter.out.persistence;

import architecture.hexagonal.adapter.out.persistence.mapper.OrderMapper;
import architecture.hexagonal.application.port.out.SaveOrderPort;
import architecture.hexagonal.domain.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderJpaRepository implements SaveOrderPort {
    private final SpringOrderRepository repo;
    private final OrderMapper mapper;

    public OrderJpaRepository(SpringOrderRepository repo, OrderMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public Order save(Order order) {
        OrderJpaEntity entity = mapper.toJpaEntity(order);
        OrderJpaEntity saved= repo.save(entity);

        return mapper.toDomain(saved);
    }
}
