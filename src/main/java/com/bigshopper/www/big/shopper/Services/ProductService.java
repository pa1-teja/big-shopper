package com.bigshopper.www.big.shopper.Services;

import com.bigshopper.www.big.shopper.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final JpaRepository<Product, Long> productRepository;

    public ProductService(JpaRepository<Product, Long> productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}