package com.example.deliveryweb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;

    private String fcmToken;

    private Integer grade;

    private String profileImage;

//    @ManyToMany(mappedBy = "users")
//    private List<Review> likedReviews;

    // Getters and setters
}