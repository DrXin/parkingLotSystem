package com.drx.mapper;

import com.drx.po.Driver;

import java.util.List;
import java.util.Map;

public interface DriverMapper {
    void insertDriver(Driver driver) throws Exception;
    Driver findDriverById(int id) throws Exception;
    Driver findDriverByUsername(String username) throws Exception;
    Driver findDriverByIdCardNum(String idCardNum) throws Exception;
    List<Driver> getDrivers()throws Exception;

    void modifyDriverName(Map<String,Object> map) throws Exception;
    void modifyGender(Map<String,Object> map) throws Exception;
    void modifyPhone(Map<String,Object> map) throws Exception;
    void modifyIdCardNum(Map<String,Object> map) throws Exception;
    void modifyAddress(Map<String,Object> map) throws Exception;

    void deleteDriverById(int driverId)throws Exception;
}
