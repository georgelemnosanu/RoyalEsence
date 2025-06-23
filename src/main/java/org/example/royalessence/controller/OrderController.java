package org.example.royalessence.controller;

import org.example.royalessence.models.Order;
import org.example.royalessence.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order created = orderService.createOrder(order);
        return ResponseEntity.ok(created);
    }

    // Get all orders (paginated)
    @GetMapping
    public ResponseEntity<Page<Order>> getAllOrders(Pageable pageable) {
        Page<Order> page = orderService.getAllOrders(pageable);
        return ResponseEntity.ok(page);
    }

    // Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Optional<Order> opt = orderService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get orders by user ID (paginated)
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<Page<Order>> getOrdersByUser(@PathVariable Integer userId, Pageable pageable) {
        Page<Order> page = orderService.getByUserId(userId, pageable);
        return ResponseEntity.ok(page);
    }

    // Update order
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        order.setId(id);
        Order updated = orderService.updateOrder(order);
        return ResponseEntity.ok(updated);
    }

    // Delete order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
