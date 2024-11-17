package com.restapi.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.products.dao.ProductsDao;
import com.restapi.products.model.Products;


@Service
public class ProductService {
    
    @Autowired
    private ProductsDao personRepository;
    
    public List<Products> getAllPersons() {
        return personRepository.findAll();
    }
    
    public Products savePerson(Products person) {
        return personRepository.save(person);
    }
    
    public Optional<Products> getPersonById(Integer id) {
        return personRepository.findById(id);
    }
    
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
