package org.example.royalessence.repository;

import org.example.royalessence.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Pentru istoricul de comenzi al unui user:
    Page<Order> findByUserId(Integer userId, Pageable pageable);
}
