package architecture.hexagonal.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringOrderRepository extends JpaRepository<OrderJpaEntity, Long> {
}
