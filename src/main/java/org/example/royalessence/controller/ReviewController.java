package org.example.royalessence.controller;

import org.example.royalessence.models.Review;
import org.example.royalessence.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Create review
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review created = reviewService.createReview(review);
        return ResponseEntity.ok(created);
    }

    // Get all reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> list = reviewService.getAllReviews();
        return ResponseEntity.ok(list);
    }

    // Get review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Integer id) {
        Optional<Review> opt = reviewService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get reviews by product ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getByProductId(@PathVariable Integer productId) {
        List<Review> list = reviewService.getByProductId(productId);
        return ResponseEntity.ok(list);
    }

    // Get single review by user and product
    @GetMapping("/by-user-and-product")
    public ResponseEntity<Review> getByUserAndProduct(@RequestParam Integer userId,
                                                      @RequestParam Integer productId) {
        Optional<Review> opt = reviewService.getByUserAndProduct(userId, productId);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update review
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Integer id, @RequestBody Review review) {
        review.setId(id);
        Review updated = reviewService.updateReview(review);
        return ResponseEntity.ok(updated);
    }

    // Delete review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
