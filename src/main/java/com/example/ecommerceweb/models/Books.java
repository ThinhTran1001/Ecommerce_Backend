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

    @ManyToOne
    @JoinColumn(name="categories_id")
    private Categories categories;

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
    private boolean status;

//    @Column
//    private List<String> DescriptionUrlImg;

    @ManyToOne
    @JoinColumn(name = "book_created_by", referencedColumnName = "user_id", nullable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users createdBy;

    @ManyToOne
    @JoinColumn(name = "book_updated_by", referencedColumnName = "user_id", nullable = true)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Users updatedBy;

    @OneToMany(mappedBy = "books")
    private List<BookOrder> bookOrderList;

    @OneToMany(mappedBy = "books")
    private List<BookCart> bookCartList;

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
