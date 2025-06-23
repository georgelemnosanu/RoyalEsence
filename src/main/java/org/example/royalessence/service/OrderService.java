package org.example.royalessence.service;

import org.example.royalessence.models.Order;
import org.example.royalessence.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Optional<Order> getById(Integer id) {
        return orderRepository.findById(id);
    }

    public Page<Order> getByUserId(Integer userId, Pageable pageable) {
        return orderRepository.findByUserId(userId, pageable);
    }

    public Order updateOrder(Order updated) {
        return orderRepository.save(updated);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
