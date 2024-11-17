package com.restapi.products.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.restapi.products.model.Products;

public interface ProductsDao extends JpaRepository<Products, Integer> {
}
