package com.project.ecommerce_backend.service;

import com.project.ecommerce_backend.model.Product;
import com.project.ecommerce_backend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductByID(int id) {
        return productRepo.findById(id).orElse(new Product(-1));
    }


    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {


        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepo.save(product);
    }


/*
we don't need to create seperate update method and add method we can use the same method
 */
//    public Product updateProduct(Product product, MultipartFile image) throws Exception {
//
//        product.setImageName(image.getOriginalFilename());
//        product.setImageType(image.getContentType());
//        product.setImageData(image.getBytes());
//        return productRepo.save(product);
//
//    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }


    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);

    }
}
