package com.frisktale.lesson1.controller;

import java.util.List;

import com.frisktale.lesson1.dao.UserDao;
import com.frisktale.lesson1.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;
    
    @RequestMapping( value = "/allUser", method = RequestMethod.GET)
    public List<User> queryAllStudent() {
        return this.userDao.getAllUser();
    }

    @RequestMapping( value = "/queryUser", method = RequestMethod.GET)
    public User queryStudentById(int id) {
        return this.userDao.getUserById(id);
    }
}