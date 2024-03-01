package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.CategoriesDTO;
import com.example.ecommerceweb.Service.ICategoriesService;
import com.example.ecommerceweb.models.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
public class CategoriesAPI {
    @Autowired
    private ICategoriesService service;

    @GetMapping(value = "/category")
    public List<Categories> getAll(){
        return service.getAllCategories();
    }
}
