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
    private String UrlImg;

    @Column
    private String DescriptionUrlImg;

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

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Collection<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Categories> categories) {
        this.categories = categories;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public Date getPublished_at() {
        return published_at;
    }

    public void setPublished_at(Date published_at) {
        this.published_at = published_at;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Users getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Users created_by) {
        this.created_by = created_by;
    }

    public Users getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(Users updated_by) {
        this.updated_by = updated_by;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getThickness() {
        return thickness;
    }

    public void setThickness(Integer thickness) {
        this.thickness = thickness;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getNumber_of_page() {
        return number_of_page;
    }

    public void setNumber_of_page(Integer number_of_page) {
        this.number_of_page = number_of_page;
    }
}
