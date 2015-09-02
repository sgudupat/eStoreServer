package com.psc.eStore.controller;

import com.psc.eStore.domain.UserAddress;
import com.psc.eStore.service.UserAddressService;
import com.psc.eStore.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserAddressController {

    @Autowired
    UserAddressService userAddressService;

    @RequestMapping("/getAddress")
    @ResponseBody
    public String getAddress(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in addAddress user");
        String userName = request.getParameter("username");

        System.out.println("User Addresses for userName:" + userName);
        try {
            List<UserAddress> userAddresses = userAddressService.getAddress(userName);
            return UserUtil.toJSONUserAddresses(userAddresses);
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping("/addAddress")
    @ResponseBody
    public String addAddress(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in addAddress user");
        UserAddress userAddress = new UserAddress();
        userAddress.setAddress1(request.getParameter("address1"));
        userAddress.setAddress2(request.getParameter("address2"));
        userAddress.setCity(request.getParameter("city"));
        userAddress.setState(request.getParameter("state"));
        userAddress.setCounty(request.getParameter("country"));
        userAddress.setPinCode(request.getParameter("pinCode"));
        userAddress.setUserName(request.getParameter("username"));

        System.out.println("User Address:" + userAddress);
        try {
            userAddressService.addAddress(userAddress);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping("/modifyAddress")
    @ResponseBody
    public String modifyAddress(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in modifyAddress user");
        UserAddress userAddress = new UserAddress();
        userAddress.setAddressId(Long.valueOf(request.getParameter("addressId")));
        userAddress.setAddress1(request.getParameter("address1"));
        userAddress.setAddress2(request.getParameter("address2"));
        userAddress.setCity(request.getParameter("city"));
        userAddress.setState(request.getParameter("state"));
        userAddress.setCounty(request.getParameter("country"));
        userAddress.setPinCode(request.getParameter("pinCode"));
        userAddress.setUserName(request.getParameter("username"));
        System.out.println("userAddress:" + userAddress);
        try {
            userAddressService.modifyAddress(userAddress);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping("/deleteAddress")
    @ResponseBody
    public String deleteAddress(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in deleteAddress user");
        String addressId = request.getParameter("addressId");
        System.out.println("Address ID:" + addressId);
        try {
            userAddressService.deleteAddress(Long.valueOf(addressId));
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
}