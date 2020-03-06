package com.example.demo02;


import com.github.pagehelper.PageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao mapper;

    public  List<User> getAllUser(int pagenum,int size) {
        PageHelper.startPage(pagenum,size);
        List<User> users = mapper.selectAll();
        return users;
    }
}
