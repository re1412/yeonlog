package com.yeon.product.repository;

import com.yeon.product.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByCode(String code);

    Page<Product> findAll(Pageable pageable);

    @Query("SELECT p.price FROM Product p WHERE p.code = :code")
    Long getPriceByCode(@Param("code") String code);

}
