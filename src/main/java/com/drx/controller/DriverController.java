package com.drx.controller;

import com.drx.po.Driver;
import com.drx.service.DriverService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/driverController")
public class DriverController {

    @Autowired
    private DriverService driverService;

    private static Logger logger = Logger.getLogger(DriverController.class);

    @RequestMapping("/register.driver")
    public String register(Driver driver) throws Exception{
        driverService.register(driver);
        return "admin";
    }

    @ResponseBody
    @RequestMapping("/getDriverMsg.username")
    public Driver getDriverMsg(@RequestParam(name = "username") String username) throws Exception{
        logger.info("获取"+username+"的信息——————");
        Driver driver = driverService.getDriverMsg(username);
        logger.info(driver);
        return driver;
    }

    @RequestMapping("/modifyMsg.change")
    @ResponseBody
    public void modifyMsg(String change)throws Exception{

        logger.info("需要修改的driver信息："+change);

        driverService.modifyMsg(change);
    }

    @RequestMapping("/showDrivers")
    @ResponseBody
    public List<Driver> showDrivers()throws Exception{
        return driverService.showDrivers();
    }

    @RequestMapping("/deleteDriver")
    @ResponseBody
    public void deleteDriver(int driverId)throws Exception{
        driverService.deleteDriver(driverId);
    }
}
