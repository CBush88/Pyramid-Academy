package com.genspark.ProductREST.Controller;

import com.genspark.ProductREST.Entity.Product;
import com.genspark.ProductREST.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return this.productService.getProducts();
    }
    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable int productId){
        return this.productService.getProductById(productId);
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }
    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return this.productService.updateProduct(product);
    }
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId){
        return this.productService.deleteProduct(productId);
    }
}
