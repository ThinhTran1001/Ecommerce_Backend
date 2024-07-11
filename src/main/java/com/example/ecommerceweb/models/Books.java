package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;
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
    @Column(name = "book_id")
    private Long id;

    @Column(name="category_id")
    private Long categoryId;

    @Column(length=150, nullable = false)
    private String bookName;

    @Column
    private String code;

    @Column
    private String avatarImg;

    @Column(nullable = false)
    private Integer price;

    @Column( length = 254,nullable = false)
    private String authorName;

    @Column(name="description")
    private String description;

    @Column(length=10)
    private String shortName;

    @Column(nullable = false)
    private Date publishedAt;

    @Column(length= 20, nullable = false)
    private String publisher;

    @Column
    private Integer quantity;

    @Column
    private Boolean isDeleted;

//    @Column
//    private List<String> DescriptionUrlImg;

    @Column
    private Integer length;

    @Column
    private Integer thickness;

    @Column
    private Integer width;

    @Column( length = 15,nullable = false)
    private String language;

    @Column
    private Integer numberOfPage;

}
