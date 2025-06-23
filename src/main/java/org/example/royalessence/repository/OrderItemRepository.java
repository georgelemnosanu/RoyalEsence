package org.example.royalessence.repository;

import org.example.royalessence.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    // Lista de articole asociate unei comenzi
    List<OrderItem> findByOrderId(Integer orderId);
}
