package com.interview.ecommerceProject.Service;

import com.interview.ecommerceProject.Model.Product;
import com.interview.ecommerceProject.Model.User;
import com.interview.ecommerceProject.Repo.ProductRepo;
import com.interview.ecommerceProject.Repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserRepo userRepo;

    private User getAuthenticatedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            return userRepo.findByEmail(userDetails.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }
        throw new RuntimeException("Invalid authentication details");
    }
    @Transactional
    public Product saveOrUpdateProduct(Product product) {
        User currentUser = getAuthenticatedUser();
        String userRole = currentUser.getRole().name();
        if (product.getProductUrl() != null) {
            Product existingProduct = productRepo.findByProductUrl(product.getProductUrl());
            if (existingProduct != null) {
                if (!userRole.equals("ADMIN") && !existingProduct.getVendor().getId().equals(currentUser.getId())) {
                    throw new RuntimeException("You do not have permission to modify this product");
                }
                existingProduct.setName(product.getName());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setCategory(product.getCategory());
                existingProduct.setScheduledStartDate(product.getScheduledStartDate());
                existingProduct.setFreeDelivery(product.getFreeDelivery());
                existingProduct.setDeliveryAmount(product.getDeliveryAmount());
                existingProduct.setOldPrice(product.getOldPrice());
                existingProduct.setNewPrice(product.getNewPrice());
                existingProduct.setImageUrl(product.getImageUrl());
                return productRepo.save(existingProduct);
            }
        }
        if (!userRole.equals("ADMIN") && !userRole.equals("VENDOR")) {
            throw new RuntimeException("Only Admin or Vendor can add products");
        }
        product.setVendor(currentUser);
        product.setProductUrl(product.getName().replace(" ", "-").toLowerCase() + "-" + UUID.randomUUID());
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    public List<Product> getProductsByVendor(Long vendorId) {
        return productRepo.findByVendorId(vendorId);
    }

    public void deleteProduct(Long id) {
        User currentUser = getAuthenticatedUser();
        String userRole = currentUser.getRole().name();
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (!userRole.equals("ADMIN") && !product.getVendor().getId().equals(currentUser.getId())) {
            throw new RuntimeException("You do not have permission to delete this product");
        }
        productRepo.deleteById(id);
    }
    public BigDecimal calculateDiscountPercentage(BigDecimal oldPrice, BigDecimal newPrice) {
        return oldPrice.subtract(newPrice)
                .divide(oldPrice, 2, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100));
    }
}
