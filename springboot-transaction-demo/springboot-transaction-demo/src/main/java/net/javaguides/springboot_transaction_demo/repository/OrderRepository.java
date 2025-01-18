package net.javaguides.springboot_transaction_demo.repository;

import net.javaguides.springboot_transaction_demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
