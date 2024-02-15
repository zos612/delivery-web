package com.example.deliveryweb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String businessHours;

    @Column(nullable = false)
    private String dayOff;

    @Column(nullable = false)
    private Integer deliveryFee;

    @Column(nullable = false)
    private Integer minimumOrderAmount;

    @Column(precision = 2, scale = 1)
    private BigDecimal averageRating;

    @Column
    private String logoImage;

    // Getters and setters
}
