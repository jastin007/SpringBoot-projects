package net.javaguides.springboot_transaction_demo.Controller;


import net.javaguides.springboot_transaction_demo.Service.OrderService;
import net.javaguides.springboot_transaction_demo.dto.OrderRequest;
import net.javaguides.springboot_transaction_demo.dto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class orderController {

    private OrderService orderService;

    public orderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> placeorder(@RequestBody OrderRequest orderRequest){
         return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
