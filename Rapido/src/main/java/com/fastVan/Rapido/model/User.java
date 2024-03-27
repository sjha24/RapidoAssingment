package com.fastVan.Rapido.model;

import com.fastVan.Rapido.model.enum_.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String token;

    @Enumerated(EnumType.STRING)
    private Role roles;

    // Relationship with shipments if the user is a driver
    @OneToMany(mappedBy = "user")
    private Set<Shipment> shipments = new HashSet<>();

}

