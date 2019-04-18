package com.drx.serviceImpl;

import com.drx.mapper.ParkingMapper;
import com.drx.po.Parking;
import com.drx.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingMapper parkingMapper;

    @Transactional
    public List<Parking> showParkings() throws Exception {
        return parkingMapper.findParkings();
    }

    @Transactional
    public void insertParkings() throws Exception {
        List<Parking> l = new ArrayList<>();
        for(int i=0; i < 100;i++){
            Parking p = new Parking();
            p.setOccupied(0);

            l.add(p);
        }
        parkingMapper.insertParkings(l);
    }

    @Transactional
    public void updateById(Map<String, Object> map) throws Exception {
        parkingMapper.updateById(map);
    }
}
