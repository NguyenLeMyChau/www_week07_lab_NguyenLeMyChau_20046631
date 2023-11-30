package vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Product;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice, Product> {
}