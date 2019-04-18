package com.drx.controller;

import com.drx.po.Car;
import com.drx.service.CarService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/carController")
public class CarController {

    private static Logger logger = Logger.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @RequestMapping("/findCarsByDriverId.driverId")
    public @ResponseBody List<Car> findCarsByDriverId(int driverId) throws Exception{
        return carService.findCarsByDriverId(driverId);
    }

    @ResponseBody
    @RequestMapping("/modifyCarMsg.car")
    public void modifyCarMsg(Car car) throws Exception{
        carService.modifyCarMsg(car);
    }

    @ResponseBody
    @RequestMapping("/deleteCar.carId")
    public void deleteCar(int carId) throws Exception{
        carService.deleteCar(carId);
    }

    @ResponseBody
    @RequestMapping("/addCar.car")
    public Car addCar(Car car) throws Exception{
        logger.info("添加的车辆信息："+car);
        Car c = carService.addCar(car);
        return c;
    }

    @ResponseBody
    @RequestMapping("/modifyCar.car")
    public Car modifyCar(Car car) throws Exception{
        logger.info("修改的车辆信息："+car);
        carService.modifyCar(car);
        return car;
    }
}
