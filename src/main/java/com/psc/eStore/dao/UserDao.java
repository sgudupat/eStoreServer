package com.psc.eStore.dao;

import com.psc.eStore.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends ConnectionDao {

    public void createUser(User user) throws Exception {
        String insertStmt = "INSERT INTO users(user_name, password, mobile, email_address, device_id, registration_id) " +
                " VALUES (:userName, :password, :mobile, :emailAddress, :deviceId, :registrationId);";
        SqlParameterSource sqlParams = new BeanPropertySqlParameterSource(user);
        try {
            this.getNamedParameterJdbcTemplate().update(insertStmt, sqlParams);
        } catch (Exception ex) {
            System.out.println("failed to insert for user_name: " + user + ex.getMessage());
            throw ex;
        }
    }

    public void updatePasswordKey(User user) throws Exception {
        String updateStmt = "UPDATE users SET password_key_value = ? WHERE user_name = ? ";
        try {
            this.getJdbcTemplate().update(updateStmt, new Object[]{user.getPasswordKeyValue(), user.getUserName()});
        } catch (Exception ex) {
            System.out.println("failed to update for user_name: " + user + ex.getMessage());
            throw ex;
        }
    }

    public User getUser(User user) {
        String selectStmt = "SELECT user_name, password, mobile, email_address, registration_id FROM users WHERE user_name = ?";
        return this.getJdbcTemplate().queryForObject(selectStmt, new Object[]{user.getUserName()}, new UserRowMapper());
    }

    private static final class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserName(rs.getString("USER_NAME"));
            user.setPassword(rs.getString("PASSWORD"));
            user.setMobile(rs.getString("MOBILE"));
            user.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
            user.setRegistrationId(rs.getString("REGISTRATION_ID"));
            return user;
        }
    }

}