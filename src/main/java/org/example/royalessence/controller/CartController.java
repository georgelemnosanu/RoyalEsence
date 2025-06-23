package org.example.royalessence.controller;

import org.example.royalessence.models.Cart;
import org.example.royalessence.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Create cart
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart created = cartService.createCart(cart);
        return ResponseEntity.ok(created);
    }

    // Get cart by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Integer id) {
        Optional<Cart> opt = cartService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get cart by user ID
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Integer userId) {
        Optional<Cart> opt = cartService.getByUserId(userId);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update cart
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Integer id, @RequestBody Cart cart) {
        cart.setId(id);
        Cart updated = cartService.updateCart(cart);
        return ResponseEntity.ok(updated);
    }

    // Delete cart
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Integer id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
