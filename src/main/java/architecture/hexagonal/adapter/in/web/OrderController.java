package architecture.hexagonal.adapter.in.web;

import architecture.hexagonal.application.port.in.PlaceOrderUseCase;
import architecture.hexagonal.application.port.in.command.PlaceOrderCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final PlaceOrderUseCase placeOrderUseCase;

    public OrderController(PlaceOrderUseCase placeOrderUseCase) {
        this.placeOrderUseCase = placeOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<Long> placeOrder(@RequestBody PlaceOrderCommand command) {
        Long orderId = placeOrderUseCase.placeOrder(command);
        return ResponseEntity.ok(orderId);
    }


}
