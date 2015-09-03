package com.psc.eStore.util;

import com.psc.eStore.domain.User;
import com.psc.eStore.domain.UserAddress;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class UserUtil {

    public static String encryptPassword(String password) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        return passwordEncryptor.encryptPassword(password);
    }

    public static boolean checkPassword(String password, String encryptedPassword) {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        return passwordEncryptor.checkPassword(password, encryptedPassword);
    }

    public static String toJSONUser(User user) {
        JSONObject userJSON = new JSONObject();
        userJSON.put("user_name", user.getUserName());
        userJSON.put("email", user.getEmailAddress());
        userJSON.put("mobile", user.getMobile());
        userJSON.put("regID", user.getRegistrationId());
        System.out.println("userJSON:" + userJSON.toJSONString());
        return userJSON.toJSONString();
    }

    public static String toJSONUserAddresses(List<UserAddress> addresses) {
        JSONArray addressesJSON = new JSONArray();
        for (UserAddress address : addresses) {
            JSONObject addressJSON = new JSONObject();
            addressJSON.put("user_name", address.getUserName());
            addressJSON.put("address_id", address.getAddressId());
            addressJSON.put("address1", address.getAddress1());
            addressJSON.put("address2", address.getAddress2());
            addressJSON.put("city", address.getCity());
            addressJSON.put("state", address.getState());
            addressJSON.put("country", address.getCountry());
            addressJSON.put("pin_code", address.getPinCode());
            addressesJSON.add(addressJSON);
        }
        System.out.println("addressesJSON:" + addressesJSON.toJSONString());
        return addressesJSON.toJSONString();
    }
}