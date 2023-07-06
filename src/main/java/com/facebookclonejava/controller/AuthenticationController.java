package com.facebookclonejava.controller;

import com.facebookclonejava.config.JwtUtil;
import com.facebookclonejava.models.User;
import com.facebookclonejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public User createUser(@RequestBody User user ){
        return userService.addUser(user);
    }


    @PostMapping("login")
    public ResponseEntity<String> authenticate(
            @RequestBody User requset
    ){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requset.getEmail(), requset.getPassword())
        );

        final User user = userService.findByEmail(requset.getEmail());

        if(user!= null){

            // TODO Add a res with the token
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }


        // TODO change the type of the method and in case the username or pass is wrong throw exception

        return ResponseEntity.status(400).body("Email Or Pass IS wrong");
    }
}
