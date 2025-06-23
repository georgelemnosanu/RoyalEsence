package org.example.royalessence.service;

import org.example.royalessence.models.OrderItem;
import org.example.royalessence.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getById(Integer id) {
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> getByOrderId(Integer orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    public OrderItem updateOrderItem(OrderItem updated) {
        return orderItemRepository.save(updated);
    }

    public void deleteOrderItem(Integer id) {
        orderItemRepository.deleteById(id);
    }
}
