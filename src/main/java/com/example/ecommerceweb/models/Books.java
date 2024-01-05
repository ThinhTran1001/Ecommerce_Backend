package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinTable(name = "category_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Collection<Categories> categories;

    @Column(length=150, nullable = false)
    private String book_name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false, length = 254)
    private String author_name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(length=10, nullable = false)
    private String short_name;

    @Column(nullable = false)
    private Date published_at;

    @Column(length= 20, nullable = false)
    private String publisher;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "book_created_by", referencedColumnName = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users created_by;

    @Column(nullable = false)
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "book_updated_by", referencedColumnName = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users updated_by;

    @Column(nullable = false)
    private Timestamp updated_at;

    @Column(nullable = false)
    private int length;

    @Column(nullable = false)
    private int thickness;

    @Column(nullable = false)
    private int width;

    @Column(nullable = false, length = 15)
    private String language;

    @Column(nullable = false)
    private int number_of_page;
}
