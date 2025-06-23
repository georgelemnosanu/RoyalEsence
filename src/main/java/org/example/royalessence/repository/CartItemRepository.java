package org.example.royalessence.repository;

import org.example.royalessence.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    // Lista tuturor item‐urilor dintr-un coș
    List<CartItem> findByCartId(Integer cartId);

    // Poți verifica dacă există deja un CartItem pentru același cart + product (după UNIQUE constraint)
    Optional<CartItem> findByCartIdAndProductId(Integer cartId, Integer productId);
}
