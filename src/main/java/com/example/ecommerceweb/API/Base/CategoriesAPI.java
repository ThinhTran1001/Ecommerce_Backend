package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.CategoriesDTO;
import com.example.ecommerceweb.Service.ICategoriesService;
import com.example.ecommerceweb.models.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class CategoriesAPI {
    @Autowired
    private ICategoriesService service;

    @GetMapping(value = "/category")
    public List<CategoriesDTO> getAll(){
        return service.getAllCategories();
    }

    @PostMapping(value = "/category",produces = "application/json;charset=UTF-8")
    public CategoriesDTO Add(@RequestBody CategoriesDTO model){
        return service.Add(model);
    }
}
