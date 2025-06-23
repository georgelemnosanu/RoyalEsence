package org.example.royalessence.repository;

import org.example.royalessence.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    // Toate elementele din wishlist-ul unui user
    List<Wishlist> findByUserId(Integer userId);

    // Pentru a evita duplicatele (user + product)
    Optional<Wishlist> findByUserIdAndProductId(Integer userId, Integer productId);
}
