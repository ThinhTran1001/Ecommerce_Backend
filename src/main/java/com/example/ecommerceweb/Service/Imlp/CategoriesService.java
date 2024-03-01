package com.example.ecommerceweb.Service.Imlp;

import com.example.ecommerceweb.Service.ICategoriesService;
import com.example.ecommerceweb.models.Categories;
import com.example.ecommerceweb.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService implements ICategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Categories> getAllCategories(){
        List<Categories> lists = categoriesRepository.findAll();
        return lists;
    }
}
