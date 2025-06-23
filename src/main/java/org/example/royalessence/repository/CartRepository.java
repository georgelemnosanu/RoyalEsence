package org.example.royalessence.repository;

import org.example.royalessence.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    // Coșul asociat unui user (dacă există)
    Optional<Cart> findByUserId(Integer userId);
}
