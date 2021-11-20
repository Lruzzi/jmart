package com.GhulamJmartAK.controller;

import com.GhulamJmartAK.dbjson.JsonTable;
import com.GhulamJmartAK.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {

    @GetMapping("/{id}")
    public default T getById(int id) {
        return getJsonTable().get(id);
    }

    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(int page, int pageSize) {
        return getJsonTable().subList(page, pageSize);
    }

}