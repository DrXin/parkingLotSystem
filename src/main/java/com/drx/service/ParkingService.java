package com.drx.service;

import com.drx.po.Parking;

import java.util.List;
import java.util.Map;

public interface ParkingService {
    List<Parking> showParkings()throws Exception;
    void insertParkings()throws Exception;
    void updateById(Map<String,Object> map)throws Exception;
}
