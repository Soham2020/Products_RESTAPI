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
    public ResponseEntity<Products> createPerson(@RequestBody Products person) {
        personService.savePerson(person);
        return ResponseEntity.ok().body(person);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        if (personService.getPersonById(id).isPresent()) {
            personService.deletePerson(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Products> updatedProducts(@PathVariable Integer id, @RequestBody Products person) {
    	if(personService.getPersonById(id).isPresent()) {
    		person.setId(id);
    		personService.savePerson(person);
    		return ResponseEntity.ok().body(person);
    	}
    	return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Integer id) {
    	if(personService.getPersonById(id).isPresent()) {
    		personService.getPersonById(id);
    		return ResponseEntity.ok().build();
    	}
    	return ResponseEntity.notFound().build();
    }
    
}