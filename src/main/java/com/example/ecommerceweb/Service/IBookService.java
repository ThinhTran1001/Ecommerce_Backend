package com.example.ecommerceweb.Service;

import com.example.ecommerceweb.DTO.BooksDTO;

public interface IBookService {
    public BooksDTO save(BooksDTO newBook);

    BooksDTO update(BooksDTO newBook);

    BooksDTO findOneBook(BooksDTO newBook);
}
