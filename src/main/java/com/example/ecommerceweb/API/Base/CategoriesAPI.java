package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.CategoriesDTO;
import com.example.ecommerceweb.Service.ICategoriesService;
import com.example.ecommerceweb.models.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoriesAPI {
    @Autowired
    private ICategoriesService service;

    @GetMapping(value = "")
    public List<CategoriesDTO> getAll(){
        return service.getAllCategories();
    }

    @PostMapping(value = "")
    public CategoriesDTO Add(@RequestBody CategoriesDTO model){
        return service.Add(model);
    }

    @PutMapping("/{id}")
    public CategoriesDTO Update(@PathVariable("id") Long id,@RequestBody CategoriesDTO model){
        model.setCategoryId(id);
        return service.Update(model);
    }

    @DeleteMapping("/{id}")
    public boolean Delete(@PathVariable("id") Long id,@RequestBody CategoriesDTO model){
        model.setCategoryId(id);
        return service.Delete(model);
    }

}
