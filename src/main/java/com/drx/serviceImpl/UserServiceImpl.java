package com.drx.serviceImpl;

import com.drx.dto.UserMsg;
import com.drx.mapper.DriverMapper;
import com.drx.mapper.UserMapper;
import com.drx.po.Driver;
import com.drx.po.User;
import com.drx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DriverMapper driverMapper;

    @Transactional
    public Map<String,Object> login(User user) throws Exception{
        /*map结构：error、code、page、user*/
        Map<String,Object> map = new HashMap<>();

        User u = userMapper.findUserByUsername(user.getUsername());

        if (u == null) {
            map.put("usernameError", "用户名不存在！");
            map.put("code",100);//100为错误码，200为成功码
            map.put("page","login");//用户名不存在则返回登录界面
            return map;
        }

        if (!user.getPassword().equals(u.getPassword())) {
            map.put("passwordError", "密码错误！");
            map.put("code",100);
            map.put("page","login");//密码错误则返回登录界面
            return map;
        }

        map.put("user",u);//登录信息无误，保存user信息到map中

        if(u.getAuthority() == 1){
            map.put("page","admin");//权限为1,则是管理员
            map.put("code",200);
            return map;
        }else if(u.getAuthority() == 0){
            map.put("page","member");//权限为0,则是普通会员
            map.put("code",200);
            return map;
        }else{
            map.put("page","login");//无权限值则返回登录界面
            map.put("code",300);//300表示无法确定用户权限
            return map;
        }
    }

    @Transactional
    public String register(UserMsg msg) throws Exception{
        String idCardNum = msg.getIdCardNum();
        Driver driver = driverMapper.findDriverByIdCardNum(idCardNum);

        User u = userMapper.findUserByDriverId(driver.getDriverId());
        if(u == null){
            User user = new User();
            user.setAuthority(0);
            user.setDriverId(driver.getDriverId());
            user.setPassword(msg.getPassword());
            user.setUsername(msg.getUsername());

            userMapper.addUser(user);
            return "注册成功！";
        }else {
            return "您之前已注册！";
        }

    }

    @Transactional
    public Map<String,Object> checkUserName(String username) throws Exception{
        User u = userMapper.findUserByUsername(username);

        Map<String,Object> map = new HashMap<>();
        if(u == null){
            map.put("code",200);
            map.put("errorMsg","用户名不存在！");//用于重置密码页面
        }else {
            map.put("code",100);
            map.put("errorMsg","用户名已被使用！请重新输入");
        }

        return map;
    }

    @Transactional
    public Map<String,Object> checkIdCardNum(String idCardNum) throws Exception{
        Driver d = driverMapper.findDriverByIdCardNum(idCardNum);

        Map<String,Object> map = new HashMap<>();
        if(d == null){
            map.put("code",100);
            map.put("errorMsg","身份证号码未登记！请联系管理员");
        }else {
            map.put("code",200);
        }
        return map;
    }

    @Transactional
    public String resetPassword(UserMsg userMsg) throws Exception{
        Driver driver = driverMapper.findDriverByIdCardNum(userMsg.getIdCardNum());
        User u = userMapper.findUserByDriverId(driver.getDriverId());

        if(u.getUsername().equals(userMsg.getUsername())){
            u.setPassword(userMsg.getPassword());

            userMapper.updateUser(u);
            return "密码修改成功！";
        }else {
            return "用户名、身份证信息不对应！";
        }

    }
}

