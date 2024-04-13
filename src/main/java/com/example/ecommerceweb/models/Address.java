package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "address")
public class Address extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String addressDetail;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users usersAddress;

}
