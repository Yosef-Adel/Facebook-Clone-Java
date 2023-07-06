package com.facebookclonejava.controller;

/*
 * @created 06/07/2023 - 12:13 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping("/user")
    public String userAuth(){
        return "user Role ";
    }

    @GetMapping("/admin")
    public String adminAuth(){
        return "Admin Role ";
    }
}
