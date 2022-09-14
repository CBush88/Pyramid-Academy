package com.genspark.ProductREST.Service;

import com.genspark.ProductREST.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    List<Product> list;

    public ProductServiceImpl() {
        list = new ArrayList<>();
        list.add(new Product(1, "CPU", "Performance"));
        list.add(new Product(2, "GPU", "Performance"));
        list.add(new Product(3, "Router", "Networking"));
    }

    @Override
    public List<Product> getProducts() {
        return list;
    }

    @Override
    public Product getProductById(int productId) {
        Product p = null;
        for(Product pr : list){
            if(pr.getProductId() == productId){
                p = pr;
                break;
            }
        }
        return p;
    }

    @Override
    public Product createProduct(Product product) {
        list.add(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        Product p = null;
        for(Product pr : list){
            if(pr.getProductId() == product.getProductId()){
                pr.setProductName(product.getProductName());
                pr.setProductCategory(product.getProductCategory());
                p = pr;
                break;
            }
        }
        return p;
    }

    @Override
    public String deleteProduct(int productId) {
        String msg = "Not successful";
        for(Product pr : list){
            if(pr.getProductId() == productId){
                list.remove(pr);
                msg = "Successfully Deleted!";
                break;
            }
        }
        return msg;
    }
}
