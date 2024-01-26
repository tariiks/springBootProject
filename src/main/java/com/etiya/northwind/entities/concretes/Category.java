package com.etiya.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "categoris")

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private int categoryId;
    @Column(name = "categoryName")
    private String categoryName;
    @OneToMany(mappedBy = "category") // Bir ürün sadece bir kategoride olabilir
    private List<Product> products;     // Bir kategori birden çok üründe olabilir
}                                       // @OneToMany kullanılır mappedBy ile..
