package com.machinestalk.machinestalktestback.services;

import com.machinestalk.machinestalktestback.entities.UserMachinestalk;
import com.machinestalk.machinestalktestback.repositories.UserMachinestalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserMachinestalkServices implements UserMachinestalkServicesImp{

    @Autowired(required = true)
    private RestTemplate restTemplate;
    @Autowired
    private UserMachinestalkRepository userMachinestalkRepository;
    public String getAllUsers(){

    String result = restTemplate.getForObject("https://gorest.co.in/public-api/users",String.class);
    return result.substring(result.indexOf("["),result.indexOf("]")+1);
    }
    public List<UserMachinestalk> USER_MACHINESTALK_LIST(){
        return userMachinestalkRepository.findAll();
    }
    public Iterable<UserMachinestalk> list() {
        return userMachinestalkRepository.findAll();
    }

    public Iterable<UserMachinestalk> saveUsers(List<UserMachinestalk> users) {
        return userMachinestalkRepository.saveAll(users);
    }

}
