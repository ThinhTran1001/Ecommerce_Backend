package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image",referencedColumnName = "id")
    private ImageData image;

    @Column(length=50, nullable = false)
    private String category_name;

    @Column(length=50, nullable = false)
    private String category_Code;

    @Column(name="status")
    private boolean status;

    @ManyToMany(mappedBy = "categories")
    private Collection<Books> books;
}
