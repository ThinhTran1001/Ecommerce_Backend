package com.example.ecommerceweb.API.Base;

import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public BooksDTO updateBook(@RequestBody BooksDTO model, @PathVariable("id") Long id){
        model.setBookId(id);
        return iBookService.save(model);
    }

    @GetMapping(value = "/book")
    public List<BooksDTO> getAll(){
        return iBookService.getAllBook();
    }
}
