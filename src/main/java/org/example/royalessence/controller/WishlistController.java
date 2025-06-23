package org.example.royalessence.controller;

import org.example.royalessence.models.Wishlist;
import org.example.royalessence.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/wishlist")
@CrossOrigin(origins = "http://localhost:3000")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    // Create wishlist item
    @PostMapping
    public ResponseEntity<Wishlist> createWishlistItem(@RequestBody Wishlist item) {
        Wishlist created = wishlistService.createWishlistItem(item);
        return ResponseEntity.ok(created);
    }

    // Get all wishlist items
    @GetMapping
    public ResponseEntity<List<Wishlist>> getAllWishlistItems() {
        List<Wishlist> list = wishlistService.getAllWishlistItems();
        return ResponseEntity.ok(list);
    }

    // Get wishlist item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getWishlistItemById(@PathVariable Integer id) {
        Optional<Wishlist> opt = wishlistService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get wishlist items by user ID
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<Wishlist>> getByUserId(@PathVariable Integer userId) {
        List<Wishlist> list = wishlistService.getByUserId(userId);
        return ResponseEntity.ok(list);
    }

    // Get single wishlist entry by user ID and product ID
    @GetMapping("/by-user-and-product")
    public ResponseEntity<Wishlist> getByUserAndProduct(@RequestParam Integer userId,
                                                        @RequestParam Integer productId) {
        Optional<Wishlist> opt = wishlistService.getByUserAndProduct(userId, productId);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update wishlist item
    @PutMapping("/{id}")
    public ResponseEntity<Wishlist> updateWishlistItem(@PathVariable Integer id, @RequestBody Wishlist item) {
        item.setId(id);
        Wishlist updated = wishlistService.updateWishlistItem(item);
        return ResponseEntity.ok(updated);
    }

    // Delete wishlist item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWishlistItem(@PathVariable Integer id) {
        wishlistService.deleteWishlistItem(id);
        return ResponseEntity.noContent().build();
    }
}
