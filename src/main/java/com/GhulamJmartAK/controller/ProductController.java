package com.GhulamJmartAK.controller;

import com.GhulamJmartAK.*;
import com.GhulamJmartAK.dbjson.JsonAutowired;
import com.GhulamJmartAK.dbjson.JsonDBEngine;
import com.GhulamJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.List;;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product> {
    @JsonAutowired(value = Product.class, filepath = "product.json")
    public static JsonTable<Product> productTable;

    @Override
    public JsonTable<Product> getJsonTable() {
        return productTable;
    }

    @GetMapping("/{id}/store")
    @ResponseBody
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ) {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }

    @PostMapping("/create")
    @ResponseBody
    Product create
            (
                    @RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans
            )
    {
        for(Product each : productTable) {
            if (each.accountId == accountId){
                Product product =  new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
    }

    @GetMapping("/getFiltered")
    @ResponseBody
    List<Product> getProductByFilter
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @RequestParam int accountId,
                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category
            )
    {
        List<Product> tempProduct = null;
        for (Product each : productTable) {
            if (each.accountId == accountId)
                if (each.name.contains(search))
                    if (minPrice <= each.price)
                        if (maxPrice >= each.price)
                            if (each.category == category)
                                tempProduct.add(each);
        }
        return tempProduct;
    }

    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }

    @Override
    public Product getById(int id) {
        return BasicGetController.super.getById(id);
    }
}
