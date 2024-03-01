package com.example.ecommerceweb.Service.Imlp;

import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.Service.IBookService;
import com.example.ecommerceweb.converter.BooksConverter;
import com.example.ecommerceweb.models.Books;
import com.example.ecommerceweb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BooksConverter booksConverter;


    @Override
    public BooksDTO save(BooksDTO newBook) {
        Books entity = new Books();
        if(newBook.getBook_id() != null){
            Books oldEntity = bookRepository.findById(newBook.getBook_id()).orElse(null);
            entity = booksConverter.toEntityUpdate(newBook, oldEntity);
        }else {
            entity = booksConverter.toEntity(newBook);
        }
        bookRepository.save(entity);
        newBook = booksConverter.toDTO(entity);
        return newBook;
    }

    @Override
    public BooksDTO update(BooksDTO newBook) {
        Books entity = new Books();
        Books oldEntity = bookRepository.findById(newBook.getBook_id()).orElse(null);
        if(newBook.getBook_id() != null && oldEntity != null){
            entity = booksConverter.toEntityUpdate(newBook, oldEntity);
        }else {
            entity = booksConverter.toEntity(newBook);
        }
        bookRepository.save(entity);
        newBook = booksConverter.toDTO(entity);
        return newBook;
    }

    @Override
    public BooksDTO findOneBook(BooksDTO newBook) {
        Books entity = bookRepository.findById(newBook.getBook_id()).orElse(null);
        if(newBook.getBook_id() != null && entity != null){
            newBook = booksConverter.toDTO(entity);
            return newBook;
        }
        return null;
    }
}
