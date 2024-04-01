package com.example.ecommerceweb.Service;

import com.example.ecommerceweb.DTO.CategoriesDTO;
import com.example.ecommerceweb.models.Categories;

import java.util.List;

public interface ICategoriesService {
    List<CategoriesDTO> getAllCategories();
    CategoriesDTO Add(CategoriesDTO newEntity);
    CategoriesDTO Update(CategoriesDTO newEntity);
    CategoriesDTO Delete(CategoriesDTO categories);
}
