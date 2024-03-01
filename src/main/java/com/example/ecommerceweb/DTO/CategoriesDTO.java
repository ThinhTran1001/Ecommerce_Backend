package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Books;
import jakarta.persistence.*;

import java.util.Collection;

public class CategoriesDTO {

    private Integer category_id;

    private String category_name;

    private String category_Code;

    private boolean status;

    private Collection<Books> books;

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_Code() {
        return category_Code;
    }

    public void setCategory_Code(String category_Code) {
        this.category_Code = category_Code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Collection<Books> getBooks() {
        return books;
    }

    public void setBooks(Collection<Books> books) {
        this.books = books;
    }
}
