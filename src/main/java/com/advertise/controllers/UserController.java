package com.advertise.controllers;

import com.advertise.dto.UserDTO;
import com.advertise.services.UserService;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseModel addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping(path = "/login/{email}/{password}")
    public UUID login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.login(email, password);
    }

}
