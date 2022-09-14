package com.genspark.ProductREST.Service;

import com.genspark.ProductREST.Entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    String deleteProduct(int productId);
}
