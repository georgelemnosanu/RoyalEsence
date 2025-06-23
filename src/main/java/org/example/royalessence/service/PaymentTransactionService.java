package org.example.royalessence.service;

import org.example.royalessence.models.PaymentTransaction;
import org.example.royalessence.repository.PaymentTransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentTransactionService {

    private final PaymentTransactionRepository paymentRepository;

    public PaymentTransactionService(PaymentTransactionRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentTransaction createTransaction(PaymentTransaction transaction) {
        return paymentRepository.save(transaction);
    }

    public List<PaymentTransaction> getAllTransactions() {
        return paymentRepository.findAll();
    }

    public Optional<PaymentTransaction> getById(Integer id) {
        return paymentRepository.findById(id);
    }

    public Optional<PaymentTransaction> getByProviderReference(String providerRef) {
        return paymentRepository.findByProviderReference(providerRef);
    }

    public PaymentTransaction updateTransaction(PaymentTransaction updated) {
        return paymentRepository.save(updated);
    }

    public void deleteTransaction(Integer id) {
        paymentRepository.deleteById(id);
    }
}
