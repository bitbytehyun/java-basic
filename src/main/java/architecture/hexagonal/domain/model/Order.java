package architecture.hexagonal.domain.model;

public class Order {
    private Long id;
    private Long customerId;
    private Long productId;
    private int quantity;
    private int totalPrice;

    private Order(Long customerId, Long productId, int quantity, int totalPrice) {
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static Order create(Long customerId, Long productId, int quantity, int pricePerUnit) {
        int total = quantity * pricePerUnit;
        return new Order(customerId, productId, quantity, total);
    }

    public Long getId() {
        return id;
    }
}
