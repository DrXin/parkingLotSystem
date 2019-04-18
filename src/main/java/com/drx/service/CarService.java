package com.drx.service;

import com.drx.po.Car;

import java.util.List;

public interface CarService {
    List<Car> findCarsByDriverId(int driverId) throws Exception;
    void modifyCarMsg(Car car) throws Exception;
    void deleteCar(int carId) throws Exception;
    Car addCar(Car car) throws Exception;
    void modifyCar(Car car) throws Exception;
}
