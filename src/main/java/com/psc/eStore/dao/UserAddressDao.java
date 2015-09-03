package com.psc.eStore.dao;

import com.psc.eStore.domain.UserAddress;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserAddressDao extends ConnectionDao {

    public void addAddress(UserAddress userAddress) throws Exception {
        String insertStmt = "INSERT INTO user_address(address1, address2, city, state, country, pin_code, user_name) " +
                " VALUES (:address1, :address2, :city, :state, :country, :pinCode, :userName);";
        SqlParameterSource sqlParams = new BeanPropertySqlParameterSource(userAddress);
        try {
            this.getNamedParameterJdbcTemplate().update(insertStmt, sqlParams);
        } catch (Exception ex) {
            System.out.println("failed to insert for user_address: " + userAddress + ex.getMessage());
            throw ex;
        }
    }

    public void modifyAddress(UserAddress userAddress) throws Exception {
        String updateStmt = "UPDATE user_address " +
                " SET address1 = :address1 " +
                "    ,address2 = :address2 " +
                "    ,city = :city " +
                "    ,state = :state " +
                "    ,country = :country " +
                "    ,pin_code = :pinCode " +
                " WHERE address_id = :addressId ";
        SqlParameterSource sqlParams = new BeanPropertySqlParameterSource(userAddress);
        try {
            this.getNamedParameterJdbcTemplate().update(updateStmt, sqlParams);
        } catch (Exception ex) {
            System.out.println("failed to update for user address: " + userAddress + ex.getMessage());
            throw ex;
        }
    }

    public void deleteAddress(Long addressId) throws Exception {
        String deleteStmt = "DELETE FROM user_address WHERE address_id = ? ";
        try {
            this.getJdbcTemplate().update(deleteStmt, new Object[]{addressId});
        } catch (Exception ex) {
            System.out.println("failed to delete address: " + addressId + ex.getMessage());
            throw ex;
        }
    }

    public List<UserAddress> getAddress(String userName) {
        String selectStmt = "SELECT address_id, address1, address2, city, state, country, pin_code, user_name FROM user_address WHERE user_name = ?";
        return this.getJdbcTemplate().query(selectStmt, new Object[]{userName}, new UserAddressRowMapper());
    }

    private static final class UserAddressRowMapper implements RowMapper<UserAddress> {
        @Override
        public UserAddress mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserAddress userAddress = new UserAddress();
            userAddress.setUserName(rs.getString("USER_NAME"));
            userAddress.setAddressId(rs.getLong("ADDRESS_ID"));
            userAddress.setAddress1(rs.getString("ADDRESS1"));
            userAddress.setAddress2(rs.getString("ADDRESS2"));
            userAddress.setCity(rs.getString("CITY"));
            userAddress.setState(rs.getString("STATE"));
            userAddress.setCountry(rs.getString("COUNTRY"));
            userAddress.setPinCode(rs.getString("PIN_CODE"));
            return userAddress;
        }
    }

}