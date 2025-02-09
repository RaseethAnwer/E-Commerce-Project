package com.interview.ecommerceProject.Controller;


import com.interview.ecommerceProject.Model.Product;
import com.interview.ecommerceProject.Repo.ProductRepo;
import com.interview.ecommerceProject.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductService productService;

    @PostMapping("/saveOrUpdate")
    public ResponseEntity<Product> saveOrUpdateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveOrUpdateProduct(product));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/{id}/discount")
    public ResponseEntity<BigDecimal> getDiscountPercentage(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            BigDecimal discount = productService.calculateDiscountPercentage(
                    product.get().getOldPrice(),
                    product.get().getNewPrice()
            );
            return ResponseEntity.ok(discount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products;
        if (name != null) {
            products = productRepo.findByNameContainingIgnoreCase(name, pageable);
        } else if (category != null) {
            products = productRepo.findByCategory(category, pageable);
        } else {
            products = productRepo.findAll(pageable);
        }
        return ResponseEntity.ok(products);
    }
}
