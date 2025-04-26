package rw.vladvisionlab.inzozi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.vladvisionlab.inzozi.models.Products;
import rw.vladvisionlab.inzozi.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Products saveProduct(Products product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public Products updateProduct(Long id, Products updatedProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setProductName(updatedProduct.getProductName());
                    product.setPrice(updatedProduct.getPrice());
                    product.setDescription(updatedProduct.getDescription());
                    product.setQuantity(updatedProduct.getQuantity());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

}
