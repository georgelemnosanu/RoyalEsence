package org.example.royalessence.controller;

import org.example.royalessence.models.ShippingAddress;
import org.example.royalessence.service.ShippingAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/shipping-addresses")
@CrossOrigin(origins = "http://localhost:3000")
public class ShippingAddressController {

    private final ShippingAddressService shippingAddressService;

    public ShippingAddressController(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    // Create address
    @PostMapping
    public ResponseEntity<ShippingAddress> createAddress(@RequestBody ShippingAddress address) {
        ShippingAddress created = shippingAddressService.createAddress(address);
        return ResponseEntity.ok(created);
    }

    // Get all addresses
    @GetMapping
    public ResponseEntity<List<ShippingAddress>> getAllAddresses() {
        List<ShippingAddress> list = shippingAddressService.getAllAddresses();
        return ResponseEntity.ok(list);
    }

    // Get address by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShippingAddress> getAddressById(@PathVariable Integer id) {
        Optional<ShippingAddress> opt = shippingAddressService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get addresses by user ID
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<ShippingAddress>> getByUserId(@PathVariable Integer userId) {
        List<ShippingAddress> list = shippingAddressService.getByUserId(userId);
        return ResponseEntity.ok(list);
    }

    // Update address
    @PutMapping("/{id}")
    public ResponseEntity<ShippingAddress> updateAddress(@PathVariable Integer id, @RequestBody ShippingAddress address) {
        address.setId(id);
        ShippingAddress updated = shippingAddressService.updateAddress(address);
        return ResponseEntity.ok(updated);
    }

    // Delete address
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        shippingAddressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
