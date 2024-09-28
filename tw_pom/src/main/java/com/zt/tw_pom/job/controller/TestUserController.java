package com.zt.tw_pom.job.controller;

import com.zt.tw_pom.job.model.TestUser;
import com.zt.tw_pom.job.service.ITestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user")
public class TestUserController {

    @Autowired
    private ITestUserService testUserService;

    @RequestMapping(value="getall",method = RequestMethod.GET)
    public List<TestUser> getAll(){
        return testUserService.list();
    }


    @RequestMapping(value = "add")
    public void AddUser(){
        TestUser u =new TestUser();
        u.setName("崔柏松");
        u.setPwd("123");
        u.setCdate(new Date());
        if(!testUserService.save(u)){
            System.out.println("插入失败");
        }else{
            System.out.println("插入成功");
        }
    }
}
