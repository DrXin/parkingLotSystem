package com.drx.service;

import com.drx.dto.TokenMsg;
import com.drx.po.Car;

import java.util.List;
import java.util.Map;

public interface TokenService {
    Map<String,Object> addToken(Car car) throws Exception;
    List<TokenMsg> showTokens(int driverId) throws Exception;
}
