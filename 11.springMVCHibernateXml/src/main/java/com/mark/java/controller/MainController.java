package com.mark.java.controller;

import com.mark.java.entity.User;
import com.mark.java.service.UserService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


/**
 * Created by mark on 4/24/15.
 */

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> home(@Valid String name){
        System.out.println(name);
        List<User> us = new ArrayList<User>();
        User u = new User();
        u.setUsername(name);
        us.add(u);
        System.out.println(u.getId());
        System.out.println(u.getUsername());
        userService.saveUsers(us);
        return userService.getAllUsernames();
    }


}
