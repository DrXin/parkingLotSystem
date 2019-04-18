package com.drx.controller;

import com.drx.dto.Time;
import com.drx.po.ParkingTime;
import com.drx.service.ParkingTimeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/parkingTimeController")
public class ParkingTimeController {

    private static Logger logger = Logger.getLogger(ParkingTimeController.class);

    @Autowired
    private ParkingTimeService parkingTimeService;

    @RequestMapping("addTime")
    @ResponseBody
    public void addTime() throws Exception {
        ParkingTime time = new ParkingTime();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String b = "2019-01-20 04:58:54";
        String e = "2019-01-20 12:25:55";

        Date begin = format.parse(b);
        Date end = format.parse(e);

        time.setBeginTime(begin);
        time.setEndTime(end);
        time.setCarId(5);

        parkingTimeService.addTime(time);
    }

    @RequestMapping("showTimes.driverId")
    @ResponseBody
    public List<Time> showTimes(int driverId) throws Exception {
        return parkingTimeService.showTimes(driverId);
    }
}
