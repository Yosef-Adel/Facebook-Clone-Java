package com.facebookclonejava;

import com.facebookclonejava.models.Role;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FacebookCloneJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacebookCloneJavaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (UserService userService){
        return args -> {

            User user = new User("yosef" ,"yosef@gmail.com", "fun123");
            userService.addUser(user);

            userService.addRole(new Role("ROLE_ADMIN"));

            userService.attachRoleToUser("yosef@gmail.com","ROLE_ADMIN" );



        };
    }


}
