package com.example.ecommerceweb.converter;

import com.example.ecommerceweb.DTO.CategoriesDTO;
import com.example.ecommerceweb.models.Categories;
import org.springframework.stereotype.Component;

@Component
public class CategoriesConverter {
    public Categories toEntity(CategoriesDTO dto){
        Categories entity = new Categories();
        entity.setCategory_Code(dto.getCategory_Code());
        entity.setCategory_name(dto.getCategory_name());
        entity.setBooks(dto.getBooks());
        return entity;
    }

    public CategoriesDTO toDTO(Categories entity){
        CategoriesDTO dto = new CategoriesDTO();
        dto.setCategory_Code(entity.getCategory_Code());
        dto.setCategory_name(entity.getCategory_name());
        dto.setBooks(entity.getBooks());
        return dto;
    }
}
