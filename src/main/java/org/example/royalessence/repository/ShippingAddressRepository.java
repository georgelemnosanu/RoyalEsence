package org.example.royalessence.repository;

import org.example.royalessence.models.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {
    // Toate adresele unui user
    List<ShippingAddress> findByUserId(Integer userId);
}
