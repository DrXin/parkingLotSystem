package com.drx.mapper;

import com.drx.dto.FareMsg;
import com.drx.po.Fare;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FareMapper {
    void insertFares(List<Fare> fares) throws Exception;
    List<FareMsg> findFaresByDriverId(int driverId)throws Exception;
    void updatePaidById(int fareId) throws Exception;
}
