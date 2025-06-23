package org.example.royalessence.controller;

import org.example.royalessence.models.CartItem;
import org.example.royalessence.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/cart-items")
@CrossOrigin(origins = "http://localhost:3000")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    // Create cart item
    @PostMapping
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
        CartItem created = cartItemService.createCartItem(cartItem);
        return ResponseEntity.ok(created);
    }

    // Get all cart items
    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> list = cartItemService.getAllCartItems();
        return ResponseEntity.ok(list);
    }

    // Get cart item by ID
    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Integer id) {
        Optional<CartItem> opt = cartItemService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all items by cart ID
    @GetMapping("/by-cart/{cartId}")
    public ResponseEntity<List<CartItem>> getByCartId(@PathVariable Integer cartId) {
        List<CartItem> list = cartItemService.getByCartId(cartId);
        return ResponseEntity.ok(list);
    }

    // Get cart item by cart ID and product ID
    @GetMapping("/by-cart-and-product")
    public ResponseEntity<CartItem> getByCartAndProduct(@RequestParam Integer cartId,
                                                        @RequestParam Integer productId) {
        Optional<CartItem> opt = cartItemService.getByCartAndProduct(cartId, productId);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update cart item
    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Integer id, @RequestBody CartItem cartItem) {
        cartItem.setId(id);
        CartItem updated = cartItemService.updateCartItem(cartItem);
        return ResponseEntity.ok(updated);
    }

    // Delete cart item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Integer id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}
