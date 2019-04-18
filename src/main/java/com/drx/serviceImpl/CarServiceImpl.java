package com.drx.serviceImpl;

import com.drx.mapper.CarMapper;
import com.drx.po.Car;
import com.drx.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Transactional
    public List<Car> findCarsByDriverId(int driverId) throws Exception{
        return carMapper.findCarsByDriverId(driverId);
    }

    @Transactional
    public void modifyCarMsg(Car car) throws Exception{
        carMapper.modifyCarMsg(car);
    }

    @Transactional
    public void deleteCar(int carId) throws Exception {
        carMapper.deleteCarById(carId);
    }

    @Transactional
    public Car addCar(Car car) throws Exception {
        carMapper.insertCar(car);
        Car c = carMapper.findCarByLicenseNum(car.getLicenseNum());
        return c;
    }

    @Transactional
    public void modifyCar(Car car) throws Exception {
        carMapper.modifyCarMsg(car);
    }
}
