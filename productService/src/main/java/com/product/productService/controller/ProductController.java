package com.product.productService.controller;

import com.product.productService.model.CustomErrorType;
import com.product.productService.model.Product;
import com.product.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long productId) {
        Product product = productService.findProductById(productId);
        if(product == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<List<Product>>( productService.findAllProducts(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long productId) {
        if (productService.deleteProductById(productId) == false){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Product is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.OK);
    }
}
