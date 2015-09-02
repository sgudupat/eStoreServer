package com.psc.eStore.controller;

import com.psc.eStore.domain.User;
import com.psc.eStore.service.UserService;
import com.psc.eStore.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/registerUser")
    @ResponseBody
    public String registerUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in register user");
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPassword(UserUtil.encryptPassword(request.getParameter("password")));
        user.setMobile(request.getParameter("mobile"));
        user.setEmailAddress(request.getParameter("email"));
        user.setDeviceId(request.getParameter("deviceId"));
        //user.setRegistrationId(request.getParameter("registrationId"));
        System.out.println("User:" + user);
        try {
            userService.createUser(user);
            return UserUtil.toJSONUser(user);
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in login user");
        User user = new User();
        user.setUserName(request.getParameter("username"));
        String password = request.getParameter("password");
        System.out.println("User:" + user);
        try {
            User dbUser = userService.getUser(user);
            if (UserUtil.checkPassword(password, dbUser.getPassword())) {
                return UserUtil.toJSONUser(dbUser);
            }
            return "fail";
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping("/isAvailable")
    @ResponseBody
    public String isAvailable(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in get user");
        User user = new User();
        user.setUserName(request.getParameter("username"));
        System.out.println("User:" + user);
        try {
            User dbUser = userService.getUser(user);
            if (dbUser == null) {
                return "success";
            }
            return "fail";
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No records");
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in get user");
        User user = new User();
        user.setUserName(request.getParameter("username"));
        System.out.println("User:" + user);
        try {
            User dbUser = userService.getUser(user);
            return UserUtil.toJSONUser(dbUser);
        } catch (Exception e) {
            return "fail";
        }
    }

    @RequestMapping("/updatePasswordKeyValue")
    @ResponseBody
    public String updatePasswordKeyValue(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("in updatePasswordKeyValue");
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPasswordKeyValue(request.getParameter("keyValue"));
        System.out.println("User:" + user);
        try {
            userService.updatePasswordKey(user);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }
}