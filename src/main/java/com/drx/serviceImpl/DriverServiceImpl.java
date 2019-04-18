package com.drx.serviceImpl;

import com.drx.mapper.DriverMapper;
import com.drx.po.Driver;
import com.drx.service.DriverService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DriverServiceImpl implements DriverService{


    private static Logger logger = Logger.getLogger(DriverServiceImpl.class);
    @Autowired
    private DriverMapper driverMapper;

    @Transactional
    public void register(Driver driver) throws Exception{
        logger.info("新注册的车主信息："+driver);

        driverMapper.insertDriver(driver);
    }

    @Transactional
    public Driver getDriverMsg(String username) throws Exception{
        return driverMapper.findDriverByUsername(username);
    }

    @Transactional
    public void modifyMsg(String change) throws Exception{

        String[] s = change.split("#");
        Map<String,Object> map = new HashMap<>();
        map.put("driverId",Integer.valueOf(s[0]));

        if(s[1].equals("t1")){
            map.put("driverName",s[2]);
            driverMapper.modifyDriverName(map);
        }else if (s[1].equals("t2")){
            map.put("gender",s[2]);
            driverMapper.modifyGender(map);
        }else if (s[1].equals("t3")){
            map.put("phone",s[2]);
            driverMapper.modifyPhone(map);
        }else if (s[1].equals("t4")){
            map.put("idCardNum",s[2]);
            driverMapper.modifyIdCardNum(map);
        }else if (s[1].equals("t5")){
            map.put("address",s[2]);
            driverMapper.modifyAddress(map);
        }

        logger.info("修改的Map信息："+map);
    }

    @Transactional
    public List<Driver> showDrivers() throws Exception {
        return driverMapper.getDrivers();
    }

    @Override
    public void deleteDriver(int driverId) throws Exception {
        driverMapper.deleteDriverById(driverId);
    }

}
