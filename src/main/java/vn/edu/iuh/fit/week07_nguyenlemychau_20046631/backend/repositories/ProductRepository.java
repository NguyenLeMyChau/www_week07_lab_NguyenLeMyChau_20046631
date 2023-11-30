package vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}