package com.example.ecommerceweb.converter;

import com.example.ecommerceweb.DTO.BooksDTO;
import com.example.ecommerceweb.models.Books;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BooksConverter {

    public Books toEntity(BooksDTO dto){
        Books book = new Books();
        book.setId(book.getId());
        book.setBookName(dto.getBookName());
        book.setAvatarImg(dto.getAvatarImg());
        book.setPrice(dto.getPrice());
        book.setAuthorName(dto.getAuthorName());
        book.setDescription(dto.getDescription());
        book.setShortName(dto.getShortName());
        book.setPublishedAt(dto.getPublishedAt());
        book.setPublisher(dto.getPublisher());
        book.setQuantity(dto.getQuantity());
        book.setStatus(dto.isStatus());
        book.setCreatedBy(dto.getCreatedBy());
        book.setLength(dto.getLength());
        book.setThickness(dto.getThickness());
        book.setWidth(dto.getWidth());
        book.setLanguage(dto.getLanguage());
        book.setNumberOfPage(dto.getNumberOfPage());
        return book;
    }

    public Books toEntityUpdate(BooksDTO dto, Books book){
        book.setBookName(dto.getBookName());
        book.setAvatarImg(dto.getAvatarImg());
        book.setPrice(dto.getPrice());
        book.setAuthorName(dto.getAuthorName());
        book.setDescription(dto.getDescription());
        book.setShortName(dto.getShortName());
        book.setPublishedAt(dto.getPublishedAt());
        book.setPublisher(dto.getPublisher());
        book.setQuantity(dto.getQuantity());
        book.setStatus(dto.isStatus());
        book.setCreatedBy(dto.getCreatedBy());
        book.setLength(dto.getLength());
        book.setThickness(dto.getThickness());
        book.setWidth(dto.getWidth());
        book.setLanguage(dto.getLanguage());
        book.setNumberOfPage(dto.getNumberOfPage());
        return book;
    }

    public BooksDTO toDTO(Books entity){
        BooksDTO dto = new BooksDTO();
        dto.setBookId(entity.getId());
        dto.setBookName(entity.getBookName());
        dto.setAvatarImg(entity.getAvatarImg());
//        dto.setDescriptionUrlImg(entity.getDescriptionUrlImg());
        dto.setPrice(entity.getPrice());
        dto.setAuthorName(entity.getAuthorName());
        dto.setDescription(entity.getDescription());
        dto.setShortName(entity.getShortName());
        dto.setPublishedAt(entity.getPublishedAt());
        dto.setPublisher(entity.getPublisher());
        dto.setQuantity(entity.getQuantity());
        dto.setStatus(entity.isStatus());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setLength(entity.getLength());
        dto.setThickness(entity.getThickness());
        dto.setWidth(entity.getWidth());
        dto.setLanguage(entity.getLanguage());
        dto.setNumberOfPage(entity.getNumberOfPage());
        return dto;
    }

    public List<BooksDTO> toListDto(List<Books> list){
        List<BooksDTO> listDto =new ArrayList<BooksDTO>();
        for (Books book : list){
            listDto.add(toDTO(book));
        }
        return listDto;
    }
}
