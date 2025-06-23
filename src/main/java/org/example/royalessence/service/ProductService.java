package org.example.royalessence.service;

import org.example.royalessence.models.Product;
import org.example.royalessence.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    public List<Product> searchByName(String namePart) {
        return productRepository.findByNameContainingIgnoreCase(namePart);
    }

    public Product updateProduct(Product updated) {
        return productRepository.save(updated);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
