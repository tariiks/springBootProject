package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.core.dtos.ProductWithCategoryDto;
import com.etiya.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Database işlemleri için verilir
public interface ProductDao extends JpaRepository<Product, Integer> {
    // Entity ve PrimaryKey türü verilir
    Product getByProductName(String productName);
    //JPARepoda getBy yazıldığında
    // Sağındaki ilgili kolona bakıyor
    // Kendisi where koşulunu otomatik yazar

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    // getBy dedikten sonra productName e bakar
    // And 'i görüp where koşulu yazar ve categorIdye bakar

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); // getBy xx Or xx
    // Select * from product where productName = xx Or categoryId = xx;

    List<Product> getByCategoryIn(List<Integer> categories); // getBy xxx In
    // Select * from product where categoryId in (1,2,3);

    List<Product> getByProductNameContains(String productName); // getBy xx Contains
    // Select * from product where productName Like '% xx %';

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);
    // getBy ile bir method yazdığımızda Query anotasyonu ile sorgu yazabiliriz
    // Çift tırnak içine from EntityClassName where EntityDeğişkenName = :Aşağıda verdiğimiz parametre

    @Query("select new com.etiya.northwind.core.dtos" +
            ".ProductWithCategoryDto(p.id, p.productName ,c.categoryName)" +
            "From Category c inner join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
