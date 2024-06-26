package com.example.ecommerceweb.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AbstractDTO<T> {

    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<T> listResult = new ArrayList<T>();
}
