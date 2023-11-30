package vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmailAndAddress(String email, String password);
}