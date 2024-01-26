package com.etiya.northwind.business.abstracts;

import com.etiya.northwind.core.dtos.ProductWithCategoryDto;
import com.etiya.northwind.core.utilities.dataResults.DataResult;
import com.etiya.northwind.core.utilities.results.Result;
import com.etiya.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {

    DataResult<List<Product>> getAll();
    Result add(Product product);


    // Kendi yazdığımız repo sorguları buraya alınır
    // DataResult ile resultCode da döndürmek için bunuda kullanabiliriz
    // Kendi yazdığımız bir classtı
    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
