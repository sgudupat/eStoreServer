package com.psc.eStore.manager;

import com.psc.eStore.dao.ProductDao;
import com.psc.eStore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductManager {

    @Autowired
    ProductDao productDao;

    public List<Product> getProducts() throws Exception {
        return productDao.getProducts();
    }
}