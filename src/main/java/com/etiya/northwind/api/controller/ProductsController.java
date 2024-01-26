package com.etiya.northwind.api.controller;


import com.etiya.northwind.business.abstracts.ProductService;
import com.etiya.northwind.core.dtos.ProductWithCategoryDto;
import com.etiya.northwind.core.utilities.dataResults.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Json veya XML yanıt döndürür
@RequestMapping("/api/products") // Class url kökü verilir
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // Veri istenilen mapping GetMapping
    // Değiştirme yapan istekler PostMapping

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){ // Giden bilgileri bir pakete koyar
                                                    // Entity de mapleme yapar
        return this.productService.add(product);
    }

    @GetMapping("/get/product/name")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName); // Bir değerle istek yaparken
                                                                    // RequestParam kullanılır
    }

    @GetMapping("/get/product/name/and/category/id")
    public DataResult<Product> getByProductNameAndCategoryId
            (@RequestParam String productName, int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }

    @GetMapping("/get/product/name/or/category/id")
    public DataResult<List<Product>> getByProductNameOrCategoryId
            (@RequestParam String productName, int categoryId){
        return this.productService.getByProductNameOrCategoryId(productName,categoryId);
    }

    @GetMapping("/get/category")
    public DataResult<List<Product>> getByCategoryIn
            (@RequestParam List<Integer> categories){
        return this.productService.getByCategoryIn(categories);
    }

    @GetMapping("/get/product/name/filter")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/get/name/and/category")
    public DataResult<List<Product>> getByNameAndCategory
            (@RequestParam String productName, int categoryId){
        return this.productService.getByNameAndCategory(productName,categoryId);
    }

    @GetMapping("/get/product/with/category")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }
}
