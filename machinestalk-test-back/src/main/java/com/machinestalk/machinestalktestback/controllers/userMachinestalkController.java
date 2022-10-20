package com.machinestalk.machinestalktestback.controllers;


import com.machinestalk.machinestalktestback.entities.UserMachinestalk;
import com.machinestalk.machinestalktestback.services.UserMachinestalkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class userMachinestalkController {
@Autowired
private UserMachinestalkServices userMachinestalkServices;

@GetMapping("/users")
    public String getUsers(){
    String result =this.userMachinestalkServices.getAllUsers();


    return result;
}
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listusers")
    public List<UserMachinestalk> getusersList(){



        return this.userMachinestalkServices.USER_MACHINESTALK_LIST();
    }
}
