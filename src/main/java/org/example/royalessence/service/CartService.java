package org.example.royalessence.service;

import org.example.royalessence.models.Cart;
import org.example.royalessence.models.User;
import org.example.royalessence.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final UserService userService;

    public CartService(CartRepository cartRepository, UserService userService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    public Cart createCart(Cart cart) {

        if (cart.getUser() != null && cart.getUser().getId() != null) {
            User user = userService.getById(cart.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

           
            Optional<Cart> existingCart = cartRepository.findByUserId(user.getId());
            if (existingCart.isPresent()) {
                return existingCart.get();
            }

            cart.setUser(user);
        }
        return cartRepository.save(cart);
    }

    public Optional<Cart> getById(Integer id) {
        return cartRepository.findById(id);
    }

    public Optional<Cart> getByUserId(Integer userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart updateCart(Cart updated) {
        return cartRepository.save(updated);
    }

    public void deleteCart(Integer id) {
        cartRepository.deleteById(id);
    }
}
