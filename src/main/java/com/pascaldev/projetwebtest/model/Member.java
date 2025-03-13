package com.pascaldev.projetwebtest.model;

import jakarta.persistence.*;

@Entity
@Table
@lombok.Getter
@lombok.Setter
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;

}
