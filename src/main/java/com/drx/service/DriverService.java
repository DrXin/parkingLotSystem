package com.drx.service;

import com.drx.po.Driver;

import java.util.List;

public interface DriverService {
    void register(Driver driver) throws Exception;
    Driver getDriverMsg(String username) throws Exception;
    void modifyMsg(String change)throws Exception;
    List<Driver> showDrivers()throws Exception;

    void deleteDriver(int driverId)throws Exception;
}
