package com.restapi.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restapi.products.model.Products;
import com.restapi.products.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    
    @Autowired
    private ProductService personService;
    
    @GetMapping
    public List<Products> getAllPersons() {
        return personService.getAllPersons();
    }
    
    
    @PostMapping
    public Products createPerson(@RequestBody Products person) {
        return personService.savePerson(person);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        if (personService.getPersonById(id).isPresent()) {
            personService.deletePerson(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}