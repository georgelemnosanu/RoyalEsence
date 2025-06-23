package org.example.royalessence.service;

import org.example.royalessence.models.ShippingAddress;
import org.example.royalessence.repository.ShippingAddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShippingAddressService {

    private final ShippingAddressRepository addressRepository;

    public ShippingAddressService(ShippingAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public ShippingAddress createAddress(ShippingAddress address) {
        return addressRepository.save(address);
    }

    public List<ShippingAddress> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<ShippingAddress> getById(Integer id) {
        return addressRepository.findById(id);
    }

    public List<ShippingAddress> getByUserId(Integer userId) {
        return addressRepository.findByUserId(userId);
    }

    public ShippingAddress updateAddress(ShippingAddress updated) {
        return addressRepository.save(updated);
    }

    public void deleteAddress(Integer id) {
        addressRepository.deleteById(id);
    }
}
