package architecture.layered;

public class OrderDto {
    private Long id;
    private String customerName;
    private String productName;
    private int quantity;
    private int totalPrice;


    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
