package com.cun.controller;

import com.cun.dao.UserDao;
import com.cun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/user")
@EnableSwagger2
public class UserController {

    @Autowired
    private UserDao userDao;

    //增
    @PostMapping("/insert")
    public User insertUser(User user){
        userDao.save(user);
        return user;
    }

    //删
    @DeleteMapping("/delete/{id}")
    public User deleteUser(@PathVariable("id") Integer id){
        User user=new User();
        user=userDao.findOne(id);
        userDao.delete(id);
        return user;
    }

   //改
    @PutMapping("/update")
    public User updateUser(User user){
        userDao.save(user);
        return user;
    }

    //查
    @GetMapping("/get/{id}")
    public User selectUser(@PathVariable("id") Integer id){
        return userDao.findOne(id);
    }

    //查全部
    @GetMapping("/all")
    public List<User> selectAllUser(){
        return userDao.findAll();
    }
}
