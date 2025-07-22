package architecture.layered;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String customerName;
    private String productName;
    private int quantity;
    private int totalPrice;

    public Order(Long id, String customerName, String productName, int quantity, int totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }
}
