package org.example.royalessence.repository;

import org.example.royalessence.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // Toate recenziile unui produs
    List<Review> findByProductId(Integer productId);

    // Un user poate avea cel mult o recenzie per produs (după UNIQUE constraint)
    Optional<Review> findByUserIdAndProductId(Integer userId, Integer productId);
}
