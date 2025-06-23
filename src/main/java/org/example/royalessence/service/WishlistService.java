package org.example.royalessence.service;

import org.example.royalessence.models.Wishlist;
import org.example.royalessence.repository.WishlistRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Wishlist createWishlistItem(Wishlist item) {
        return wishlistRepository.save(item);
    }

    public List<Wishlist> getAllWishlistItems() {
        return wishlistRepository.findAll();
    }

    public Optional<Wishlist> getById(Integer id) {
        return wishlistRepository.findById(id);
    }

    public List<Wishlist> getByUserId(Integer userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Optional<Wishlist> getByUserAndProduct(Integer userId, Integer productId) {
        return wishlistRepository.findByUserIdAndProductId(userId, productId);
    }

    public Wishlist updateWishlistItem(Wishlist updated) {
        return wishlistRepository.save(updated);
    }

    public void deleteWishlistItem(Integer id) {
        wishlistRepository.deleteById(id);
    }
}
