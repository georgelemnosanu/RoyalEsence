package org.example.royalessence.repository;

import org.example.royalessence.models.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Integer> {
    // Poți căuta tranzacția după referință (providerReference)
    Optional<PaymentTransaction> findByProviderReference(String providerReference);
}
