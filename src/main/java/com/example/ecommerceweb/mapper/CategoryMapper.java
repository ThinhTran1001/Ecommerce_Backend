package com.example.ecommerceweb.mapper;

import com.example.ecommerceweb.DTO.CategoriesDTO;
import com.example.ecommerceweb.models.Categories;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoriesDTO toCategoriesDto(Categories categories);

    Categories toCategories(CategoriesDTO categoriesDTO);
}
