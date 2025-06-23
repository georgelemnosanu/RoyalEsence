package org.example.royalessence.controller;

import org.example.royalessence.models.OrderItem;
import org.example.royalessence.service.OrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/order-items")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Create order item
    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem created = orderItemService.createOrderItem(orderItem);
        return ResponseEntity.ok(created);
    }

    // Get all order items
    @GetMapping
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> list = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(list);
    }

    // Get order item by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Integer id) {
        Optional<OrderItem> opt = orderItemService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get items by order ID
    @GetMapping("/by-order/{orderId}")
    public ResponseEntity<List<OrderItem>> getByOrderId(@PathVariable Integer orderId) {
        List<OrderItem> list = orderItemService.getByOrderId(orderId);
        return ResponseEntity.ok(list);
    }

    // Update order item
    @PutMapping("/{id}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Integer id, @RequestBody OrderItem orderItem) {
        orderItem.setId(id);
        OrderItem updated = orderItemService.updateOrderItem(orderItem);
        return ResponseEntity.ok(updated);
    }

    // Delete order item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Integer id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
