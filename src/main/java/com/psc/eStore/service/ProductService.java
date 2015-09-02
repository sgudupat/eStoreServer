package com.psc.eStore.service;

import com.psc.eStore.domain.Product;
import com.psc.eStore.domain.User;
import com.psc.eStore.manager.ProductManager;
import com.psc.eStore.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService {

    @Autowired
    ProductManager productManager;

    public List<Product> getProducts() throws Exception {
        return productManager.getProducts();
    }
}