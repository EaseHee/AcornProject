package com.erp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.erp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	//대분류 코드와 소분류 코드로 1개의 소분류 데이터 조회
    @Query("SELECT p FROM Product p WHERE p.productCode = ?1")
    Product findProductOne(String productCode);

    /**
     * Dashboard 상품 재고 수량 목록 출력을 위한 메서드
     * @param pageable
     * @return
     */
    @Query("SELECT p FROM Product p WHERE p.productEa < 23")
	Page<Product> getPartProductList(Pageable pageable);
}