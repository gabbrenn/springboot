package rw.vladvisionlab.inzozi.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.vladvisionlab.inzozi.models.Products;
import rw.vladvisionlab.inzozi.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all products", e);
        }
    }

    public Optional<Products> getProductById(Long id){
        try {
            return productRepository.findById(id); 
        } catch (Exception e) {
            throw new RuntimeException("Error fetching One products", e);
        }
        
    }

    public Products saveProduct(Products product){
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new RuntimeException("Error Creating products", e);
        }
        
    }


    public Products updateProduct(Long id, Products updatedProduct) {
        try {
            return productRepository.findById(id)
                .map(product -> {
                    product.setProductName(updatedProduct.getProductName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setDescription(updatedProduct.getDescription());
                    product.setQuantity(updatedProduct.getQuantity());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        } catch (Exception e) {
            throw new RuntimeException("Error Updating products", e);
        }
        
    }

    public void deleteProduct(Long id){
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error Deleting products", e);
        }
        
        
    }

}
