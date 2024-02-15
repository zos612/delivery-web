package com.example.deliveryweb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    private String description;

    private String options;

    private String image;

    // Getters and setters
}

