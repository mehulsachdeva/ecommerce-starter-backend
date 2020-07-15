package com.service.eCommerceStarter.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, updatable = false)
    private long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "is_available", nullable = false)
    private int isAvailable;

    @Column(name = "images", nullable = false)
    private String images;

    @Column(name = "artist_info", nullable = false)
    private String artistInfo;

    @Column(name = "version", nullable = false)
    @Version
    private long version;
}
