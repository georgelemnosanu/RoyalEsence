package org.example.royalessence.service;

import org.example.royalessence.models.Review;
import org.example.royalessence.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getById(Integer id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getByProductId(Integer productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Optional<Review> getByUserAndProduct(Integer userId, Integer productId) {
        return reviewRepository.findByUserIdAndProductId(userId, productId);
    }

    public Review updateReview(Review updated) {
        return reviewRepository.save(updated);
    }

    public void deleteReview(Integer id) {
        reviewRepository.deleteById(id);
    }
}
