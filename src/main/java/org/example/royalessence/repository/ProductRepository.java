package org.example.royalessence.repository;

import org.example.royalessence.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>,
        JpaSpecificationExecutor<Product> {
    // Poți defini metode suplimentare, de ex.:
     List<Product> findByNameContainingIgnoreCase(String namePart);
}
