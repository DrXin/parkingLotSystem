package com.drx.controller;

import com.drx.dto.UserMsg;
import com.drx.po.User;
import com.drx.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping("/login.user")
//    @ResponseBody
    public String login(User user, HttpServletRequest request) throws Exception {

        Map<String, Object> map = userService.login(user);

        logger.info(map);
        if((int)map.get("code") == 100){
            if (map.get("passwordError") != null){
                request.setAttribute("passwordError",map.get("passwordError"));
            }

            if(map.get("usernameError") != null){
                request.setAttribute("usernameError",map.get("usernameError"));
            }

            return "redirect:/"+map.get("page");
        }else if((int)map.get("code") == 200){
            request.getSession().setAttribute("user",map.get("user"));//把user信息存放到session域
            return "redirect:/"+map.get("page");
        }else{
            return "redirect:/"+map.get("page");
        }

    }

    @RequestMapping("/register.user")
    public String register(UserMsg msg, HttpServletRequest request) throws Exception {
        logger.info("注册信息："+msg);

        String registration_msg = userService.register(msg);
        request.getSession().setAttribute("jumping_msg",registration_msg);

        return "jump";
    }

    //退出系统
    @RequestMapping("/signOut")
    public String signOut(boolean logout,HttpServletRequest request){
        if (logout){
            request.getSession().removeAttribute("user");
        }
        return "redirect:/";
    }

    @RequestMapping("/checkUserName.username")
    @ResponseBody
    public Map<String,Object> checkUserName(String username) throws Exception{
        return userService.checkUserName(username);
    }

    @RequestMapping("/checkIdCardNum.idCardNum")
    @ResponseBody
    public Map<String,Object> checkIdCardNum(String idCardNum) throws Exception{
        return userService.checkIdCardNum(idCardNum);
    }

    @RequestMapping("/resetPassword.user")
    public String resetPassword(UserMsg userMsg, HttpServletRequest request) throws Exception{
        String s = userService.resetPassword(userMsg);
        request.getSession().setAttribute("jumping_msg",s);
        return "jump";
    }

}
