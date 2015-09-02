package com.psc.eStore.domain;

public class User {

    private String userName;
    private String password;
    private String mobile;
    private String emailAddress;
    private String deviceId;
    private String registrationId;
    private String passwordKeyValue;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getPasswordKeyValue() {
        return passwordKeyValue;
    }

    public void setPasswordKeyValue(String passwordKeyValue) {
        this.passwordKeyValue = passwordKeyValue;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", registrationId='" + registrationId + '\'' +
                ", passwordKeyValue='" + passwordKeyValue + '\'' +
                '}';
    }
}