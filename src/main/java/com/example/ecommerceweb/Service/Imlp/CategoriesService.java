package com.example.ecommerceweb.Service.Imlp;

import com.example.ecommerceweb.DTO.CategoriesDTO;
import com.example.ecommerceweb.Service.ICategoriesService;
import com.example.ecommerceweb.converter.CategoriesConverter;
import com.example.ecommerceweb.models.Categories;
import com.example.ecommerceweb.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService implements ICategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Autowired
    private CategoriesConverter categoriesConverter;

    @Override
    public List<CategoriesDTO> getAllCategories(){
        return categoriesConverter.toListDTO(categoriesRepository.findAll());
    }

    @Override
    public CategoriesDTO Add(CategoriesDTO newEntity) {
        Categories entity = categoriesConverter.toEntity(newEntity);
        categoriesRepository.save(entity);
        return newEntity;
    }

    @Override
    public CategoriesDTO Update(CategoriesDTO newEntity) {
        return null;
    }

    @Override
    public CategoriesDTO Delete(CategoriesDTO categories) {
        return null;
    }


}
