package com.example.deliveryweb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "review")
public class Review {

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
    private Integer rating;

    @Column(nullable = false)
    private String content;

    private String images;

    @Column(nullable = false)
    private LocalDateTime createdAt;
//
//    @ManyToMany
//    @JoinTable(name = "likes",
//            joinColumns = @JoinColumn(name = "review_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> users;

    // Getters and setters
}