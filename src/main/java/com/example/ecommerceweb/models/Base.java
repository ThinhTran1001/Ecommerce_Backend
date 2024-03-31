package com.example.ecommerceweb.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Base {

    @Column
    private Date createdDate;
    @Column
    private Date updatedDate;
}
