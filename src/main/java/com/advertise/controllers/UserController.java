package com.advertise.controllers;

import com.advertise.dto.UserDTO;
import com.advertise.services.UserService;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseModel addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

}
