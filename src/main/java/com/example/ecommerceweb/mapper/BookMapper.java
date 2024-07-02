package com.example.ecommerceweb.mapper;


import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.models.Books;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BooksDTO toBooksDto(Books books);

    Books toBook(BooksDTO booksDTO);

}
