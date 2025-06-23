package org.example.royalessence.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart_items",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_cart_product", columnNames = {"cart_id", "product_id"})
        })
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Column(name = "added_at", nullable = false, updatable = false)
    private LocalDateTime addedAt;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @PrePersist
    protected void onCreate() {
        addedAt = LocalDateTime.now();
    }
}
