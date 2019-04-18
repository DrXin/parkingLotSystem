package com.drx.mapper;

import com.drx.dto.TokenMsg;
import com.drx.po.Token;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenMapper {
    void insertToken(Token token) throws Exception;
    Token findTokenByCarId(int carId) throws Exception;
    List<TokenMsg> findTokensByDriverId(int driverId) throws Exception;
}
