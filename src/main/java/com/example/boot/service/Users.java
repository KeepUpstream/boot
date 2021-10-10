package com.example.boot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Users {
    @RequestMapping("userList")
    public List getUsers(){
        List<Map<String,Object>> initList = new ArrayList<>();
        Map temp = new HashMap<>();
        temp.put("id",1);
        temp.put("name","朱一丁");
        temp.put("age",25);
        temp.put("birth","1996-10-01");
        initList.add(temp);
        temp = new HashMap<>();
        temp.put("id",2);
        temp.put("name","牛二");
        temp.put("age",16);
        temp.put("birth","2005-5-23");
        initList.add(temp);
        temp = new HashMap<>();
        temp.put("id",3);
        temp.put("name","刘三");
        temp.put("age",44);
        temp.put("birth","1987-2-28");
        initList.add(temp);

        return initList;

    }
}
