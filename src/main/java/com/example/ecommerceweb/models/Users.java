package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int user_id;

    @Column(length=50, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length =50, nullable = false)
    private String email;

    @Column(name="status")
    private boolean status;

    @Column(length=100, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Roles role_id;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;

    @OneToMany(mappedBy = "created_by", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<Books> books_created;

    @OneToMany(mappedBy = "updated_by", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<Books> books_updated;
}
