package rw.vladvisionlab.inzozi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    
    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products product ){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
