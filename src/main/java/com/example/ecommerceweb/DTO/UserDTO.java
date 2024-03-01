package com.example.ecommerceweb.DTO;

import com.example.ecommerceweb.models.Books;
import com.example.ecommerceweb.models.Roles;
import jakarta.persistence.*;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Collection;

public class UserDTO {
    private Integer user_id;
    private String username;
    private String password;
    private String email;
    private boolean status;
    private String address;
    private Roles role_id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Collection<Books> books_created;
    private Collection<Books> books_updated;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Roles getRole_id() {
        return role_id;
    }

    public void setRole_id(Roles role_id) {
        this.role_id = role_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Collection<Books> getBooks_created() {
        return books_created;
    }

    public void setBooks_created(Collection<Books> books_created) {
        this.books_created = books_created;
    }

    public Collection<Books> getBooks_updated() {
        return books_updated;
    }

    public void setBooks_updated(Collection<Books> books_updated) {
        this.books_updated = books_updated;
    }
}
