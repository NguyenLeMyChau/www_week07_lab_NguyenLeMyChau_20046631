package vn.edu.iuh.fit.week07_nguyenlemychau_20046631.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Customer;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Product;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.services.ProductServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductServices productServices;

    @GetMapping("/products")
    public String showProduct(HttpSession session, Model model) {
        model.addAttribute("products", productServices.findAll());

        Customer customer = (Customer) session.getAttribute("customer");

        if(customer != null){
            model.addAttribute("customer", customer);
        }
        else{
            String name = "Login";
            model.addAttribute("customer", new Customer(name));
        }

        return "client/product/listing";
    }

    @GetMapping("/buy/{id}")
    public String buy(HttpSession session, @PathVariable("id") long id){
        Optional<Product> p = productServices.findById(id);

        List<Product> listProduct = null;
        Object obj = session.getAttribute("cart");
        if(obj == null)
            listProduct = new ArrayList<>();
        else
            listProduct = (ArrayList<Product>) obj;

        listProduct.add(p.get());

        session.setAttribute("cart", listProduct);

        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String checkout(HttpSession session, Model model){
        List<Product> listProduct = (List<Product>) session.getAttribute("cart");

        model.addAttribute("products", listProduct);

        if(listProduct == null){
            double total = 0;
            model.addAttribute("total", total);
        }
        else{
            // Tính tổng giá trị
            double total = listProduct.stream()
                    .mapToDouble(product -> product.getProductPrices().get(0).getPrice())
                    .sum();
            model.addAttribute("total", total);
        }
        return "client/cart";
    }

    @GetMapping("/pay")
    public String pay(HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/products";
    }

}
