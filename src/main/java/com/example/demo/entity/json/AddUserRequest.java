package com.example.demo.entity.json;

/**
 * @author Vivek
 * @since 04/07/17
 */
public class AddUserRequest {

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
