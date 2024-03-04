package com.example.deliveryweb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    private String orderedMenus;

    @Column(nullable = false)
    private LocalDateTime orderTime;

    @Column(nullable = false)
    private String orderStatus;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private Integer paymentAmount;

    @Column(nullable = false)
    private String deliveryAddress;

    private LocalDateTime deliveryRequestTime;

    private LocalDateTime deliveryCompletedTime;

}
