package com.drx.mapper;

import com.drx.po.Car;

import java.util.List;

public interface CarMapper {
    void insertCar(Car car) throws Exception;
    List<Car> findCarsByDriverId(int driverId) throws Exception;
    List<Integer> findCarIdsByDriverId(int driverId) throws Exception;
    Car findCarByLicenseNum(String licenseNum) throws Exception;
    void modifyCarMsg(Car car) throws Exception;
    void deleteCarById(int carId) throws Exception;
}
