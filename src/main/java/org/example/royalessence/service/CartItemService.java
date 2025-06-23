package org.example.royalessence.service;

import org.example.royalessence.models.Cart;
import org.example.royalessence.models.CartItem;
import org.example.royalessence.models.Product;
import org.example.royalessence.repository.CartItemRepository;
import org.example.royalessence.repository.CartRepository;
import org.example.royalessence.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartItemService(CartItemRepository cartItemRepository,
                           CartRepository cartRepository,
                           ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public CartItem createCartItem(CartItem cartItem) {

        if (cartItem.getProduct() == null || cartItem.getProduct().getId() == null) {
            throw new RuntimeException("Product must be specified");
        }

        Product product = productRepository.findById(cartItem.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));


        Cart cart;
        if (cartItem.getCart() != null && cartItem.getCart().getId() != null) {

            cart = cartRepository.findById(cartItem.getCart().getId())
                    .orElseThrow(() -> new RuntimeException("Cart not found"));
        } else {

            cart = new Cart();
            cartRepository.save(cart);
        }


        Optional<CartItem> existingItem = cartItemRepository.findByCartIdAndProductId(
                cart.getId(),
                product.getId()
        );

        if (existingItem.isPresent()) {

            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + cartItem.getQuantity());
            return cartItemRepository.save(item);
        } else {

            cartItem.setCart(cart);
            cartItem.setProduct(product);
            return cartItemRepository.save(cartItem);
        }
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public Optional<CartItem> getById(Integer id) {
        return cartItemRepository.findById(id);
    }

    public List<CartItem> getByCartId(Integer cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    public Optional<CartItem> getByCartAndProduct(Integer cartId, Integer productId) {
        return cartItemRepository.findByCartIdAndProductId(cartId, productId);
    }

    public CartItem updateCartItem(CartItem updated) {
        return cartItemRepository.save(updated);
    }

    public void deleteCartItem(Integer id) {
        cartItemRepository.deleteById(id);
    }
}
