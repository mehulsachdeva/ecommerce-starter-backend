package com.service.eCommerceStarter.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchases")
public class Purchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", unique = true, updatable = false)
    private long purchaseId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "products")
    private String products;

    @Column(name = "total_amount")
    private String totalAmount;

    @Column(name = "payment_option")
    private String paymentOption;

    @Column(name = "payment_status")
    private String paymentStatus;
}
