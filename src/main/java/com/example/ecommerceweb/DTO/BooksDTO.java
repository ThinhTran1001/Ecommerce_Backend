package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Categories;
import com.example.ecommerceweb.models.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class BooksDTO extends AbstractDTO implements Serializable {
    private Long bookId;
    private Collection<Categories> categories;
    private String bookName;
    private String avatarImg;
    private List<String> DescriptionUrlImg;
    private Integer price;
    private String authorName;
    private String description;
    private String shortName;
    private Date publishedAt;
    private String publisher;
    private Integer quantity;
    private Boolean isDeleted;
    private Users createdBy;
    private Users updatedBy;
    private Integer length;
    private Integer thickness;
    private Integer width;
    private String language;
    private Integer numberOfPage;
}
