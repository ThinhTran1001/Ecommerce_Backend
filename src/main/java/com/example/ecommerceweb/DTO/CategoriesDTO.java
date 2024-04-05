package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Books;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class CategoriesDTO {

    private Integer category_id;
    private ImageDataDTO image;

    private String category_name;

    private String category_Code;

    private boolean status;

    private Collection<Books> books;
}
