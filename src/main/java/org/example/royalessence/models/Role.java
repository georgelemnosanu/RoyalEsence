package org.example.royalessence.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 30)
    private String name; // ex: ROLE_USER, ROLE_ADMIN

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();
}
