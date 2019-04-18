package com.drx.serviceImpl;

import com.drx.dto.FareMsg;
import com.drx.dto.Time;
import com.drx.mapper.CarMapper;
import com.drx.mapper.FareMapper;
import com.drx.mapper.ParkingTimeMapper;
import com.drx.po.Car;
import com.drx.po.Fare;
import com.drx.service.FareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FareServiceImpl implements FareService {

    @Autowired
    private FareMapper fareMapper;

    @Autowired
    private ParkingTimeMapper parkingTimeMapper;

    @Autowired
    private CarMapper carMapper;

    @Transactional
    public void addFare(int driverId) throws Exception {
        List<Fare> list = new ArrayList<>();
        List<Car> cars = carMapper.findCarsByDriverId(driverId);

        for (Car car:cars) {
            if (car.getFormulaId() == 1){
                Map<String,Object> map = new HashMap<>();
                map.put("carId",car.getCarId());
                map.put("formulaId",car.getFormulaId());
                List<Time> times = parkingTimeMapper.findTimesByCarIdAndFormulaId(map);

                for (Time time:times) {
                    Fare fare = new Fare();
                    fare.setCarId(car.getCarId());
                    fare.setPaid(0);
                    fare.setTimeId(time.getTimeId());
                    fare.setTotal(time.getTotalTime()*5);

                    list.add(fare);
                }
            }
        }
        fareMapper.insertFares(list);
    }

    @Transactional
    public List<FareMsg> showFares(int driverId) throws Exception {
        return fareMapper.findFaresByDriverId(driverId);
    }

    @Transactional
    public void pay(int fareId) throws Exception {
        fareMapper.updatePaidById(fareId);
    }
}
