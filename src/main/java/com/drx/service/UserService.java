package com.drx.service;

import com.drx.dto.UserMsg;
import com.drx.po.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> login(User user) throws Exception;
    String register(UserMsg msg) throws Exception;
    Map<String,Object> checkUserName(String username) throws Exception;
    Map<String,Object> checkIdCardNum(String username) throws Exception;
    String resetPassword(UserMsg UserMsg) throws Exception;
}
