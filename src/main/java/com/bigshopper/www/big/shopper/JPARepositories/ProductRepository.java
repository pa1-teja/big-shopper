package com.bigshopper.www.big.shopper.JPARepositories;

import com.bigshopper.www.big.shopper.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}