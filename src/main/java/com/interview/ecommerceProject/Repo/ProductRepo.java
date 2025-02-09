package com.interview.ecommerceProject.Repo;

import com.interview.ecommerceProject.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Product> findByCategory(String category, Pageable pageable);
    List<Product> findByVendorId(Long vendorId);
    @Query("SELECT p FROM Product p WHERE p.productUrl = :productUrl")
    Product findByProductUrl(String productUrl);


}
