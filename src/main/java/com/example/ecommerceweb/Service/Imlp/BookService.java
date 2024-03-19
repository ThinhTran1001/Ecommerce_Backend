package com.example.ecommerceweb.Service.Imlp;

import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.Service.IBookService;
import com.example.ecommerceweb.converter.BooksConverter;
import com.example.ecommerceweb.models.Books;
import com.example.ecommerceweb.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BooksConverter booksConverter;


    @Override
    public BooksDTO save(BooksDTO newBook) {
        Books entity = new Books();
        entity = booksConverter.toEntity(newBook);
        bookRepository.save(entity);
        newBook = booksConverter.toDTO(entity);
        return newBook;
    }

    @Override
    public BooksDTO update(BooksDTO newBook) {
        Books entity = new Books();

        if(newBook.getBook_id() != null){
            Books oldEntity = bookRepository.findById(newBook.getBook_id()).orElseThrow(() -> new EntityNotFoundException("Entity not found from database. "));
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

    @Override
    public BooksDTO delete(BooksDTO newBook) {
        if(newBook.getBook_id() != null){
            Books oldEntity = bookRepository.findById(newBook.getBook_id()).orElseThrow(() -> new EntityNotFoundException("Entity not found from database. "));
            bookRepository.delete(oldEntity);
            newBook = booksConverter.toDTO(oldEntity);
        }
        return newBook;
    }

    @Override
    public List<BooksDTO> getAllBook() {
        return booksConverter.toListDto(bookRepository.findAll());
    }
}
