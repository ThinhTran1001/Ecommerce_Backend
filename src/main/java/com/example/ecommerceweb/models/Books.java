package com.example.ecommerceweb.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_order",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id",
                    referencedColumnName = "order_id"))
    private List<Orders> orders;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_cart",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id",
                    referencedColumnName = "cart_id"))
    private List<Carts> carts;

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
