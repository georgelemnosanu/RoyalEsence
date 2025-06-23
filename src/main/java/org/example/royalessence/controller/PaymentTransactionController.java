package org.example.royalessence.controller;

import org.example.royalessence.models.PaymentTransaction;
import org.example.royalessence.service.PaymentTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/payment-transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentTransactionController {

    private final PaymentTransactionService paymentTransactionService;

    public PaymentTransactionController(PaymentTransactionService paymentTransactionService) {
        this.paymentTransactionService = paymentTransactionService;
    }

    // Create transaction
    @PostMapping
    public ResponseEntity<PaymentTransaction> createTransaction(@RequestBody PaymentTransaction transaction) {
        PaymentTransaction created = paymentTransactionService.createTransaction(transaction);
        return ResponseEntity.ok(created);
    }

    // Get all transactions
    @GetMapping
    public ResponseEntity<List<PaymentTransaction>> getAllTransactions() {
        List<PaymentTransaction> list = paymentTransactionService.getAllTransactions();
        return ResponseEntity.ok(list);
    }

    // Get transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransaction> getById(@PathVariable Integer id) {
        Optional<PaymentTransaction> opt = paymentTransactionService.getById(id);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get transaction by provider reference
    @GetMapping("/by-reference/{providerRef}")
    public ResponseEntity<PaymentTransaction> getByProviderReference(@PathVariable String providerRef) {
        Optional<PaymentTransaction> opt = paymentTransactionService.getByProviderReference(providerRef);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update transaction
    @PutMapping("/{id}")
    public ResponseEntity<PaymentTransaction> updateTransaction(@PathVariable Integer id, @RequestBody PaymentTransaction transaction) {
        transaction.setId(id);
        PaymentTransaction updated = paymentTransactionService.updateTransaction(transaction);
        return ResponseEntity.ok(updated);
    }

    // Delete transaction
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id) {
        paymentTransactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
