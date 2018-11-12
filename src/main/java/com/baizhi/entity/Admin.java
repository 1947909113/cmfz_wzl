package com.baizhi.entity;

public class Admin {

    private String id;
    private String phone;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String id, String phone, String password) {
        this.id = id;
        this.phone = phone;
        this.password = password;
    }

    public Admin() {

    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
