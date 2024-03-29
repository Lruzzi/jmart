package com.GhulamJmartAK.controller;

/**
 * Class yang berfungsi untuk generic get data menggunakan Id dan get data dengan page atau halaman
 * @author Ghulam Izzul Fuad
 */

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.GhulamJmartAK.Algorithm;
import com.GhulamJmartAK.dbjson.*;

@RestController
public interface BasicGetController <T extends Serializable> {

    @GetMapping("/{id}")
    public default T getById (@PathVariable int id){

        return Algorithm.<T>find(getJsonTable(),e -> e.id == id);
    }

    public abstract JsonTable<T> getJsonTable ();

    @GetMapping("/page")
    public default List<T> getPage(int page, int pageSize){
        final JsonTable<T> table = getJsonTable();
        return Algorithm.paginate(table,page,pageSize,o->true);
    }

}