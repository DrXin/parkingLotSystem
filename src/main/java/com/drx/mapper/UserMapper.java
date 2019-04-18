package com.drx.mapper;

import com.drx.po.User;

public interface UserMapper {
    User findUserByUsername(String username) throws Exception;
    User findUserByDriverId(int driverId) throws Exception;
    void addUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
}
