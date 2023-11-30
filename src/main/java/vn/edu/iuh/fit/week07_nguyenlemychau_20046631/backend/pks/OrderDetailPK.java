package vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.pks;

import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Order;
import vn.edu.iuh.fit.week07_nguyenlemychau_20046631.backend.models.Product;

import java.io.Serializable;

@Setter @Getter
public class OrderDetailPK implements Serializable {
    private Order order;
    private Product product;
}