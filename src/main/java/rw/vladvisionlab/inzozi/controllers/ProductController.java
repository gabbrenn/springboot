package rw.vladvisionlab.inzozi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rw.vladvisionlab.inzozi.services.ProductService;
import rw.vladvisionlab.inzozi.models.Products;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Products> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Products createProduct(@RequestBody Products product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
