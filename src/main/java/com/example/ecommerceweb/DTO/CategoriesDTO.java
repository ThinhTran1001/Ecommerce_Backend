package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Books;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class CategoriesDTO implements Serializable {


    private Long categoryId;
    private ImageDataDTO image;


    private String categoryName;

    private String categoryCode;

    private boolean status;

    private List<Books> books;
}
