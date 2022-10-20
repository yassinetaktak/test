package com.machinestalk.machinestalktestback;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.machinestalk.machinestalktestback.entities.UserMachinestalk;
import com.machinestalk.machinestalktestback.services.UserMachinestalkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sun.misc.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class MachinestalkTestBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MachinestalkTestBackApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
   @Autowired
   private UserMachinestalkServices userMachinestalkServices;

    @Bean
    CommandLineRunner runner(UserMachinestalkServices userMachinestalkServices) {
        return args -> {
            // read json and write to db

            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<UserMachinestalk>> typeReference = new TypeReference<List<UserMachinestalk>>(){};
            String result = userMachinestalkServices.getAllUsers();
            InputStream inputStream = new ByteArrayInputStream(result.getBytes());

            try {
                List<UserMachinestalk> users = mapper.readValue(inputStream,typeReference);
                userMachinestalkServices.saveUsers(users);
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
