package vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Customer;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer loginCustomer(String email, String password){
        return customerRepository.findCustomerByEmailAndAddress(email, password);
    }
}
