package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Categories;
import com.example.ecommerceweb.models.Users;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BooksDTO extends AbstractDTO<BooksDTO>{
    private Integer book_id;
    private Collection<Categories> categories;
    private String book_name;
    private String avatarImg;
    private List<String> DescriptionUrlImg;
    private Integer price;
    private String author_name;
    private String description;
    private String short_name;
    private Date published_at;
    private String publisher;
    private Integer quantity;
    private boolean status;
    private Users created_by;
    private Users updated_by;
    private Integer length;
    private Integer thickness;
    private Integer width;
    private String language;
    private Integer number_of_page;
}
