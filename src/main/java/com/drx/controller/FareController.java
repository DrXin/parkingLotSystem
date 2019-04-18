package com.drx.controller;

import com.drx.dto.FareMsg;
import com.drx.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("fareController")
public class FareController {
    @Autowired
    private FareService fareService;

    @RequestMapping("addFares.driverId")
    @ResponseBody
    public void addFares(int driverId)throws Exception{
        fareService.addFare(driverId);
    }

    @RequestMapping("showFares")
    @ResponseBody
    public List<FareMsg> showFares(int driverId) throws Exception{
        return fareService.showFares(driverId);
    }

    @RequestMapping("pay")
    @ResponseBody
    public void pay(int fareId) throws Exception{
        fareService.pay(fareId);
    }
}
