package org.example.royalessence.service;

import org.example.royalessence.models.Inventory;
import org.example.royalessence.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getById(Integer id) {
        return inventoryRepository.findById(id);
    }

    public Optional<Inventory> getByProductId(Integer productId) {
        return inventoryRepository.findByProductId(productId);
    }

    public Inventory updateInventory(Inventory updated) {
        return inventoryRepository.save(updated);
    }

    public void deleteInventory(Integer id) {
        inventoryRepository.deleteById(id);
    }
}
