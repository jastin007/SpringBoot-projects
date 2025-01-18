package net.javaguides.springboot_transaction_demo.Service.Impl;

import net.javaguides.springboot_transaction_demo.Exception.PaymentException;
import net.javaguides.springboot_transaction_demo.Service.OrderService;
import net.javaguides.springboot_transaction_demo.dto.OrderRequest;
import net.javaguides.springboot_transaction_demo.dto.OrderResponse;
import net.javaguides.springboot_transaction_demo.entity.Order;
import net.javaguides.springboot_transaction_demo.entity.Payment;
import net.javaguides.springboot_transaction_demo.repository.OrderRepository;
import net.javaguides.springboot_transaction_demo.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTracking(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type do not support");
        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTracking());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Success");
        return orderResponse;
    }
}
