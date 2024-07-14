package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Categories extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img_id_avatar")
    private Long imageIdAvatar;

    @Column(length=50, nullable = false)
    private String categoryName;

    @Column(length=50, nullable = false)
    private String categoryCode;

    @Column(name="status")
    private boolean status;

    @Column(name = "img_id_brand")
    private Long imgIdBrand;

}
