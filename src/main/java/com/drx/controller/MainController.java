package com.drx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

//@RequestMapping("system")
@Controller
public class MainController {
    @RequestMapping("/")
    public String main(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String toRegister(HttpServletRequest request){
        return "register";
    }

    @RequestMapping("/member")
    public String signIn(){
        return "member";
    }

    @RequestMapping("/admin")
    public String toAdmin(){
        return "admin";
    }

    @RequestMapping("/passwordReset")
    public String toPasswordReset(){
        return "passwordReset";
    }
}
