package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "books")
public class Books extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinTable(name = "category_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Collection<Categories> categories;

    @Column(length=150, nullable = false)
    private String book_name;

    @Column
    private String avatarImg;

    @Column
    private List<String> DescriptionUrlImg;

    @Column(nullable = false)
    private Integer price;

    @Column( length = 254,nullable = false)
    private String author_name;

    @Column(name="description")
    private String description;

    @Column(length=10)
    private String short_name;

    @Column(nullable = false)
    private Date published_at;

    @Column(length= 20, nullable = false)
    private String publisher;

    @Column
    private Integer quantity;

    @Column
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "book_created_by", referencedColumnName = "user_id", nullable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users created_by;

    @ManyToOne
    @JoinColumn(name = "book_updated_by", referencedColumnName = "user_id", nullable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users updated_by;

    @Column
    private Integer length;

    @Column
    private Integer thickness;

    @Column
    private Integer width;

    @Column( length = 15,nullable = false)
    private String language;

    @Column
    private Integer number_of_page;

}
