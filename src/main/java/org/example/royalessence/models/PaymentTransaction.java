package org.example.royalessence.models;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_transactions")
@Data
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "currency", nullable = false, length = 10)
    private String currency; // ex: RON, EUR

    @Column(name = "payment_method", nullable = false, length = 30)
    private String paymentMethod; // ex: CARD, PAYPAL, BANK_TRANSFER

    @Column(name = "provider_reference", length = 100)
    private String providerReference; // id-ul primit de la procesator

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "transaction_date", nullable = false, updatable = false)
    private LocalDateTime transactionDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    @PrePersist
    protected void onCreate() {
        transactionDate = LocalDateTime.now();
    }
}
