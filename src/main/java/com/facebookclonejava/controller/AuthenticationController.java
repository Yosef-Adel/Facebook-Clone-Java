package com.facebookclonejava.controller;

import com.facebookclonejava.config.JwtUtil;
import com.facebookclonejava.controller.Request.UserRequest;
import com.facebookclonejava.controller.Response.LoginResponse;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 06/07/2023 - 12:09 PM
 * @project Facebook-Clone-Java
 * @author Yosef Adel Mahmoud Saaid
 */
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    private final UserService userService;

    @PostMapping("/signup")
    public User createUser(@RequestBody UserRequest request ){
        return userService.addUser(request);
    }


    @PostMapping("/login")
    public LoginResponse login( @RequestBody UserRequest requset){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requset.getEmail(), requset.getPassword())
        );
        final User user = userService.findByEmail(requset.getEmail());
        String token = jwtUtil.generateToken(user);
        return new LoginResponse(user, token);
    }
}
