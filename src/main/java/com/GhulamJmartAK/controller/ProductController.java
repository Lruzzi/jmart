package com.GhulamJmartAK.controller;

/**
 * Class yang digunakan untuk pengolahan data product
 * seperti create product, filter, dan pengambilan data product yang terdaftar dari sebuah toko
 */

import com.GhulamJmartAK.*;
import com.GhulamJmartAK.dbjson.JsonAutowired;
import com.GhulamJmartAK.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>
{
    @JsonAutowired(value = Product.class,filepath = "Product.json")
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
            )
    {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }

    @PostMapping("/create")
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
        for(Account each : AccountController.accountTable) {
            if (each.id == accountId && each.store != null){
                Product product =  new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
                productTable.add(product);
                return product;
            }
        }
        return null;
    }

    @GetMapping("/getFiltered")
    @ResponseBody
    List<Product> getProductByFilter(@RequestParam int page, @RequestParam int pageSize, @RequestParam String search,
                                     @RequestParam int minPrice, @RequestParam int maxPrice, @RequestParam ProductCategory category,
                                     @RequestParam boolean conditionUsed) {
        List<Product> tempProduct = new ArrayList<Product>();
        for (Product iterate : productTable) {
            if (iterate.name.contains(search))
                if (minPrice <= iterate.price)
                    if (maxPrice >= iterate.price)
                        if (iterate.category == category)
                            if (iterate.conditionUsed == conditionUsed)
                                tempProduct.add(iterate);
        }
        return Algorithm.paginate(tempProduct, page, pageSize, pred -> pred.weight != 0);
    }
}