package com.justinbushy.calendarapi.controllers;

import com.justinbushy.calendarapi.models.User;
import com.justinbushy.calendarapi.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public User registerUser(@RequestBody User user)
    {
        try{
            userDao.save(user);
        }
        catch (Exception e){
            return null;
        }
        return user;
    }

}
