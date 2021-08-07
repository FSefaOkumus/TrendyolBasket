package com.pcb.ProductCouchbase.service;

import com.pcb.ProductCouchbase.model.Product;
import com.pcb.ProductCouchbase.repo.ProductRepo;
import com.pcb.ProductCouchbase.request.ProductChangeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepository;

    public ProductService(ProductRepo productRepository, Publisher publisher) {
        this.productRepository = productRepository;
        this.publisher = publisher;
    }

    private final Publisher publisher;



    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent()) {
            throw new RuntimeException("There is already a product with given barcode : " + product.getId());
        }
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public Product findProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Product not found with id %s", id)));
    }




    //KAFKA PRODUCER PART

    public void updateProductPrice(ProductChangeRequest request) {

        Product product = findProductById(request.getId());

        double currentPrice = product.getPrice();

        product.setPrice(request.getPrice());

        productRepository.save(product);

        if (currentPrice != request.getPrice()) {
            publisher.publishProductPriceChangeEvent(product.getId());
        }
    }

    public void updateProductStock(ProductChangeRequest request){
        Product product = findProductById(request.getId());

        Integer currentStock = product.getStock();

        product.setStock(request.getStock());

        productRepository.save(product);

        if (currentStock == 0) {
            publisher.publishOutOfStockEvent(product.getId());

        }
        else if (currentStock < 3) {
            publisher.publishStockChangeEvent(product.getId());
        }
    }

}