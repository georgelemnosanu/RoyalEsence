package org.example.royalessence.controller;

import org.example.royalessence.models.Inventory;
import org.example.royalessence.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/inventory")
@CrossOrigin(origins = "http://localhost:3000")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // Create inventory record
    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        Inventory created = inventoryService.createInventory(inventory);
        return ResponseEntity.ok(created);
    }

    // Get all inventory records
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> list = inventoryService.getAllInventories();
        return ResponseEntity.ok(list);
    }

    // Get inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getById(@PathVariable Integer id) {
        Optional<Inventory> opt = inventoryService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get inventory by product ID
    @GetMapping("/by-product/{productId}")
    public ResponseEntity<Inventory> getByProductId(@PathVariable Integer productId) {
        Optional<Inventory> opt = inventoryService.getByProductId(productId);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update inventory record
    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Integer id, @RequestBody Inventory inventory) {
        inventory.setId(id);
        Inventory updated = inventoryService.updateInventory(inventory);
        return ResponseEntity.ok(updated);
    }

    // Delete inventory record
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Integer id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.noContent().build();
    }
}
