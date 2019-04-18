package com.drx.controller;

import com.drx.dto.TokenMsg;
import com.drx.po.Car;
import com.drx.po.Token;
import com.drx.service.TokenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("tokenController")
public class TokenController {

    private static Logger logger = Logger.getLogger(TokenController.class);

    @Autowired
    private TokenService tokenService;

    @RequestMapping("addToken.car")
    @ResponseBody
    public Map<String,Object> addToken(Car car) throws Exception {

        logger.info("购买卡券的车辆："+car);

        return tokenService.addToken(car);
    }

    @RequestMapping("showTokens.driverId")
    @ResponseBody
    public List<TokenMsg> showTokens(int driverId) throws Exception {
        return tokenService.showTokens(driverId);
    }
}
