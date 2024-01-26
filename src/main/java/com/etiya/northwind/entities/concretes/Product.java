package com.etiya.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Otomatik getter ve setter oluşturur
@NoArgsConstructor // Parametresiz constructor
@AllArgsConstructor // Parametreli constructor oluşturur

@Entity // Databasede bir tabloya karşılık geldiğini belirtir
@Table(name = "products") // Entity altına tablo adı verilir


public class Product {

    @Id // İşlemler primaryKey e göre yapılır, ID 'nin verilmesi gerekir
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDnin nasıl artılacağını verir
    @Column(name = "productId") // Databasedeki kolon isimleri verilir
    private int id;
    //. @Column(name = "categoryId")    // Altta @OneToMany anotasyonu olduğu için bu yazılmaz
    //. private int categoryId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "unitPrice")
    private double unitPrice;
    @Column(name = "unitsInStock")
    private short unitsInStock;
    @Column(name = "quantityPerUnit")
    private String quantityPerUnit;
    @ManyToOne()                          // @OneToMany anotasyonunun paraleli
    @JoinColumn(name = "categoryId")    // Bir kategory birden fazla üründe olabilir
    private Category category;          // ManyToOne kullanılır JoinColumn ile


}
