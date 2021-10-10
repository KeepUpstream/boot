package com.example.boot.controller;

import com.example.boot.service.Users;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
//@CrossOrigin("http://127.0.0.1:8085")
public class LoginCtrl {

    @RequestMapping("/login")
    public String loginInit(){
        return "hello";
    }

    @RequestMapping("/tosubmit")
    public ModelAndView loginToSubmit(ServletRequest request, ServletResponse response){
        ModelAndView mv=new ModelAndView();
        mv.addObject("user","aihui");
        mv.addObject("password","aihui123");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping("/submit")
    @ResponseBody
    public Map loginSubmit(ServletRequest request, ServletResponse response){

        int loginCode = -1;
        String user = request.getParameter("user");
        String pwd  = request.getParameter("password");
        Map dataMap = new HashMap<>();

        if(user!=null && pwd!=null){
            if(user.equals("aihui") && pwd.equals("aihui123")){
                loginCode = 1;//密码正确

                Users users = new Users();
                List<Map<String,Object>> initList = users.getUsers();

                dataMap.put("pagePath","/home");
                dataMap.put("initData",initList);
            }else{
                loginCode = 0;//客户端试图绕过登录页

            }
        }
        dataMap.put("loginCode", loginCode);

        return dataMap;
    }

    @RequestMapping("/home")
    public ModelAndView home(ServletRequest request, ServletResponse response){
        ModelAndView mv=new ModelAndView();
        mv.addObject("user","aihui");
        mv.addObject("password","aihui123");
        mv.setViewName("hello");
        return mv;
    }
}
