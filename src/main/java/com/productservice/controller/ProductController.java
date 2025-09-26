package com.productservice.controller;

import com.productservice.ProductService.ProductService;
import com.productservice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) { this.service = service; }

    @GetMapping
    public List<Product> all() { return service.findAll(); }
    @GetMapping("/{id}") public Product one(@PathVariable Long id) { return service.findById(id); }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product created = service.create(product);
        return ResponseEntity.created(URI.create("/products/" + created.getId())).body(created);
    }

    @PutMapping("/{id}") public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
