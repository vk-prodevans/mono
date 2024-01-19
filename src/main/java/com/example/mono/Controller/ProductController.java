package com.example.mono.Controller;

import com.example.mono.entity.Product;
import com.example.mono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/addProductForm")
    public ResponseEntity<String> showAddProductForm() {
        // Assuming addProductForm is a client-side feature and doesn't need a server response
        return ResponseEntity.status(HttpStatus.OK).body("Add Product Form");
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = service.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        List<Product> savedProducts = service.saveProducts(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducts);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = service.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getProducts();
        return ResponseEntity.ok(products);
    }
}
