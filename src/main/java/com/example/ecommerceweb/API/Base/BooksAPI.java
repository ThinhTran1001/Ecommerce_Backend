package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class BooksAPI {

    @Autowired
    private IBookService iBookService;

    @PostMapping(value = "/book")
    public BooksDTO createNewBook(@RequestBody BooksDTO model){
        return iBookService.save(model);
    }

    @PutMapping(value = "/book/{id}")
    public BooksDTO updateBook(@RequestBody BooksDTO model, @PathVariable("id") Integer id){
        model.setBook_id(id);
        return iBookService.save(model);
    }
}
