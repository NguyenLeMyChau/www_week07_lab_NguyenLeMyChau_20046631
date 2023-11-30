package vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Product;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }


}
