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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image",referencedColumnName = "id")
    private ImageData image;

    @Column(length=50, nullable = false)
    private String categoryName;

    @Column(length=50, nullable = false)
    private String categoryCode;

    @Column(name="status")
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_brand", referencedColumnName = "id")
    private ImageData img;

    @OneToMany(mappedBy = "categories")
    private List<Books> books;


}
