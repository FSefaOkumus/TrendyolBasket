package com.pcb.ProductCouchbase.controller;

import com.pcb.ProductCouchbase.model.Product;
import com.pcb.ProductCouchbase.repo.CustomerRepo;
import com.pcb.ProductCouchbase.repo.ProductRepo;
import com.pcb.ProductCouchbase.request.ProductChangeRequest;
import com.pcb.ProductCouchbase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductByBarcode(@PathVariable String id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
    }


    //KAFKA PRODUCER PART

    @PutMapping("/priceChange/{barcode}")
    public void updateProductPrice(@RequestBody ProductChangeRequest request, @PathVariable String barcode) {
        request.setId(barcode);
        productService.updateProductPrice(request);
    }

    @PutMapping("/stockChange/{barcode}")
    public void updateProductStock(@RequestBody ProductChangeRequest request, @PathVariable String barcode) {
        request.setId(barcode);
        productService.updateProductStock(request);
    }


}
