package net.javaguides.springboot_transaction_demo.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.springboot_transaction_demo.entity.Order;
import net.javaguides.springboot_transaction_demo.entity.Payment;



public class OrderRequest {
    private Order order;
    private Payment payment;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
