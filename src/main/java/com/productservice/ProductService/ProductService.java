package com.productservice.ProductService;

import com.productservice.model.Product;
import com.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;
    public ProductService(ProductRepository repo) { this.repo = repo; }

    public List<Product> findAll() { return repo.findAll(); }

    public Product findById(Long id) { return repo.findById(id).orElseThrow(); }

    public Product create(Product p) { return repo.save(p); }

    public Product update(Long id, Product p) {
        Product e = findById(id);
        e.setName(p.getName());
        e.setPrice(p.getPrice());
        return repo.save(e);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
