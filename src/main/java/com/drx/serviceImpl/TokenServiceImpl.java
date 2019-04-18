package com.drx.serviceImpl;

import com.drx.IdWorker;
import com.drx.dto.TokenMsg;
import com.drx.mapper.TokenMapper;
import com.drx.po.Car;
import com.drx.po.Token;
import com.drx.service.TokenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TokenServiceImpl implements TokenService {

    private static Logger logger = Logger.getLogger(TokenServiceImpl.class);

    @Autowired
    private TokenMapper tokenMapper;

    @Transactional
    public List<TokenMsg> showTokens(int driverId) throws Exception {
        return tokenMapper.findTokensByDriverId(driverId);
    }

    @Transactional
    public Map<String, Object> addToken(Car car) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Date today = new Date();

        Token t = tokenMapper.findTokenByCarId(car.getCarId());
        if (t == null){
            selectToken(car.getFormulaId(),map,tokenMapper,today,car.getCarId());
        }else {
            if (today.getTime() < t.getEndTime().getTime()){
                map.put("code",200);
                map.put("error","您的这辆车还有卡券尚未过期！");
            }else {
                selectToken(car.getFormulaId(),map,tokenMapper,today,car.getCarId());
            }
        }

        map.put("licenseNum",car.getLicenseNum());
        return map;
    }


    private static void selectToken(int formulaId,Map<String,Object> map,TokenMapper tokenMapper,Date today,int carId) throws Exception {
        if (formulaId == 2){
            Token tokenForMonth = createTokenForMonth(carId,today);
            tokenMapper.insertToken(tokenForMonth);
            map.put("token",tokenForMonth);
        }else if (formulaId == 3){
            Token tokenForYear = createTokenForYear(carId,today);
            tokenMapper.insertToken(tokenForYear);
            map.put("token",tokenForYear);
        }
        map.put("code",100);
    }

    private static Token createTokenForMonth(int carId,Date begin) throws ParseException {
        Token token = new Token();

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = f.parse(f.format(begin));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,30);
        Date end = calendar.getTime();
        Date endTime = f.parse(f.format(end));
        logger.info("-----当天日期:"+beginTime+",月卡到期日期："+endTime);

        long tokenNum = IdWorker.getId();

        token.setBeginTime(beginTime);
        token.setCarId(carId);
        token.setEndTime(endTime);
        token.setTokenNum(tokenNum);
        return token;
    }
    private static Token createTokenForYear(int carId,Date begin) throws ParseException {
        Token token = new Token();

        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = f.parse(f.format(begin));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,365);
        Date end = calendar.getTime();
        Date endTime = f.parse(f.format(end));
        logger.info("-----当天日期:"+beginTime+",年卡到期日期："+endTime);

        long tokenNum = IdWorker.getId();

        token.setBeginTime(beginTime);
        token.setCarId(carId);
        token.setEndTime(endTime);
        token.setTokenNum(tokenNum);
        return token;
    }
}
