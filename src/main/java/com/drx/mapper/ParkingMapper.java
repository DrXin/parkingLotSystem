package com.drx.mapper;

import com.drx.po.Parking;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ParkingMapper {
    List<Parking> findParkings()throws Exception;
    void insertParkings(List<Parking> list)throws Exception;
    void updateById(Map<String,Object> map)throws Exception;
}
