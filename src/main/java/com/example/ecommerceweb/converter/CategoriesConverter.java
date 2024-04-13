package com.example.ecommerceweb.converter;

import com.example.ecommerceweb.DTO.CategoriesDTO;
import com.example.ecommerceweb.models.Categories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriesConverter {
    public Categories toEntity(CategoriesDTO dto){
        Categories entity = new Categories();
        entity.setId(dto.getCategoryId());
        entity.setCategoryCode(dto.getCategoryCode());
        entity.setCategoryName(dto.getCategoryName());
        entity.setBooks(dto.getBooks());
        return entity;
    }

    public CategoriesDTO toDTO(Categories entity){
        CategoriesDTO dto = new CategoriesDTO();
        dto.setCategoryId(entity.getId());
        dto.setCategoryCode(entity.getCategoryCode());
        dto.setCategoryName(entity.getCategoryName());
        dto.setBooks(entity.getBooks());
        return dto;
    }

    public Categories toUpdate(Categories entity, CategoriesDTO dto){
        entity.setCategoryCode(dto.getCategoryCode());
        entity.setCategoryName(dto.getCategoryName());
        entity.setStatus(dto.isStatus());
        entity.setBooks(dto.getBooks());
        return entity;
    }

    public List<CategoriesDTO> toListDTO(List<Categories> list){
        List<CategoriesDTO> listDto = new ArrayList<>();
        for (Categories categories: list){
            listDto.add(toDTO(categories));
        }

        return listDto;
    }


}
