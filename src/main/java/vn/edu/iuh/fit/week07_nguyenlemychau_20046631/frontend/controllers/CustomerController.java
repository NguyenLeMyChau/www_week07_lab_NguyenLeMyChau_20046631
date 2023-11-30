package vn.edu.iuh.fit.week07_nguyenlemychau_20046631.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Customer;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.services.CustomerServices;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/customers")
    public String showCustomer(Model model) {
        model.addAttribute("customers", customerServices.findAll());
        return "client/customer";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "client/login";
    }

    @PostMapping("/login")
    public String loginPost(HttpSession session, @RequestParam String email, @RequestParam String password ) {
        Customer customer = customerServices.loginCustomer(email, password);
        if (customer != null) {
            session.setAttribute("customer", customer);
            return "redirect:/products";
        }
        else{
            return "redirect:/login";
        }
    }

    @GetMapping("/customer-info")
    public String showCustomerInfo(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
         model.addAttribute("customer", customer);
         return "client/customer";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("customer");
        return "redirect:/products";
    }

}
