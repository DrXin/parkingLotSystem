package com.drx.controller;

import com.drx.po.Parking;
import com.drx.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("parkingController")
public class ParkingController {
    @Autowired
    private ParkingService parkingService;

    @RequestMapping("showParkings")
    @ResponseBody
    public List<Parking> showParkings() throws Exception {
        return parkingService.showParkings();
    }

    @RequestMapping("insertParkings")
    @ResponseBody
    public void insertParkings()throws Exception{
        parkingService.insertParkings();
    }

    @RequestMapping("updateById")
    @ResponseBody
    public void updateById(Map<String,Object> map) throws Exception {
        parkingService.updateById(map);
    }
}
