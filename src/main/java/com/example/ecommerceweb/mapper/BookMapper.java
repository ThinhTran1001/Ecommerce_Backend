package com.example.ecommerceweb.mapper;


import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.models.Books;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {
    BooksDTO toBookDTO(Books books);

    Books toBook(BooksDTO booksDTO);

}
