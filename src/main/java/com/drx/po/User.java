package com.drx.po;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Alias("user")
public class User implements Serializable {
    private int userId;
    private String username;
    private String password;
    private int authority;
    private int driverId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
