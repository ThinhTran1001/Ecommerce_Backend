package com.example.ecommerceweb.converter;

import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.models.Books;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BooksConverter {

    public Books toEntity(BooksDTO dto){
        Books book = new Books();
        book.setBook_name(dto.getBook_name());
        book.setPrice(dto.getPrice());
        book.setAuthor_name(dto.getAuthor_name());
        book.setDescription(dto.getDescription());
        book.setShort_name(dto.getShort_name());
        book.setPublished_at(dto.getPublished_at());
        book.setPublisher(dto.getPublisher());
        book.setQuantity(dto.getQuantity());
        book.setStatus(dto.isStatus());
        book.setCreated_by(dto.getCreated_by());
        book.setLength(dto.getLength());
        book.setThickness(dto.getThickness());
        book.setWidth(dto.getWidth());
        book.setLanguage(dto.getLanguage());
        book.setNumber_of_page(dto.getNumber_of_page());
        return book;
    }

    public Books toEntityUpdate(BooksDTO dto, Books book){
        book.setBook_name(dto.getBook_name());
        book.setPrice(dto.getPrice());
        book.setAuthor_name(dto.getAuthor_name());
        book.setDescription(dto.getDescription());
        book.setShort_name(dto.getShort_name());
        book.setPublished_at(dto.getPublished_at());
        book.setPublisher(dto.getPublisher());
        book.setQuantity(dto.getQuantity());
        book.setStatus(dto.isStatus());
        book.setCreated_by(dto.getCreated_by());
        book.setLength(dto.getLength());
        book.setThickness(dto.getThickness());
        book.setWidth(dto.getWidth());
        book.setLanguage(dto.getLanguage());
        book.setNumber_of_page(dto.getNumber_of_page());
        return book;
    }

    public BooksDTO toDTO(Books entity){
        BooksDTO dto = new BooksDTO();
        dto.setBook_name(entity.getBook_name());
        dto.setPrice(entity.getPrice());
        dto.setAuthor_name(entity.getAuthor_name());
        dto.setDescription(entity.getDescription());
        dto.setShort_name(entity.getShort_name());
        dto.setPublished_at(entity.getPublished_at());
        dto.setPublisher(entity.getPublisher());
        dto.setQuantity(entity.getQuantity());
        dto.setStatus(entity.isStatus());
        dto.setCreated_by(entity.getCreated_by());
        dto.setLength(entity.getLength());
        dto.setThickness(entity.getThickness());
        dto.setWidth(entity.getWidth());
        dto.setLanguage(entity.getLanguage());
        dto.setNumber_of_page(entity.getNumber_of_page());
        return dto;
    }
}
