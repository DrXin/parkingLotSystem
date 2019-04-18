package com.drx.service;

import com.drx.dto.Time;
import com.drx.po.ParkingTime;

import java.util.List;

public interface ParkingTimeService {
    void addTime(ParkingTime time) throws Exception;
    List<Time> showTimes(int driverId)throws Exception;
}
