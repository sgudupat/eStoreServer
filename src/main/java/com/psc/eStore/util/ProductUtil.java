package com.psc.eStore.util;

import com.psc.eStore.domain.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class ProductUtil {

    public static String toJSONProducts(List<Product> prods) {
        JSONArray prodsJSON = new JSONArray();
        for (Product prod : prods) {
            JSONObject prodJSON = new JSONObject();
            prodJSON.put("code", prod.getCode());
            prodJSON.put("name", prod.getName());
            prodJSON.put("category", prod.getCategory());
            prodJSON.put("price", prod.getPrice());
            prodJSON.put("image", prod.getImageName());
            prodJSON.put("specification", prod.getSpecification());
            prodsJSON.add(prodJSON);
        }
        System.out.println("prodsJSON:" + prodsJSON.toJSONString());
        return prodsJSON.toJSONString();
    }
}