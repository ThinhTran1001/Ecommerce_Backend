package com.example.ecommerceweb.Service;

import com.example.ecommerceweb.DTO.BooksDTO;

import java.util.List;

public interface IBookService {
    public BooksDTO save(BooksDTO newBook);

    BooksDTO update(BooksDTO newBook);

    BooksDTO findOneBook(BooksDTO newBook);

    BooksDTO delete(BooksDTO newBook);

    List<BooksDTO> getAllBook();
}
