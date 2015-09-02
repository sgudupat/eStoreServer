package com.psc.eStore.dao;

import com.psc.eStore.domain.Product;
import com.psc.eStore.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDao extends ConnectionDao {

    public List<Product> getProducts() {
        String selectStmt = "SELECT code, name, category, price, image, specification FROM products ORDER BY creation_date desc ";
        return this.getJdbcTemplate().query(selectStmt, new ProductRowMapper());
    }

    private static final class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setCode(rs.getString("CODE"));
            product.setName(rs.getString("NAME"));
            product.setCategory(rs.getString("CATEGORY"));
            product.setPrice(rs.getString("PRICE"));
            product.setImageName(rs.getString("IMAGE"));
            product.setSpecification(rs.getString("SPECIFICATION"));
            return product;
        }
    }
}