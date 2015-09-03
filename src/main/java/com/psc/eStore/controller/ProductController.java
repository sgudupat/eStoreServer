package com.psc.eStore.controller;

import com.psc.eStore.domain.Product;
import com.psc.eStore.service.ProductService;
import com.psc.eStore.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/getProducts")
    @ResponseBody
    public String getProducts(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in getProducts");
        try {
            List<Product> products = productService.getProducts();
            return ProductUtil.toJSONProducts(products);
        } catch (Exception e) {
            return "fail";
        }
    }
}