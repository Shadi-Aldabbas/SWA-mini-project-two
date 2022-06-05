package com.product.productService.service;

import com.product.productService.model.Product;
import com.product.productService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public Product findProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
    public List<Product> findAllProducts() {
        var result = new ArrayList<Product>();
        productRepository.findAll().forEach(item -> {
            Product product = item;
            result.add(product);
        });
        return result;
    }
    public Product updateProductById(Product product, Long productId){
        return productRepository.save(product);
    }
    public Boolean deleteProductById(Long productId){
        var product = productRepository.findById(productId);
        if (product.isPresent()){
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }
}
