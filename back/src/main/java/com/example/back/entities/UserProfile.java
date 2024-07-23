package com.example.back.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user_profiles")
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
