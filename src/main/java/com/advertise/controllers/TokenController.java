package com.advertise.controllers;

import com.advertise.services.TokenService;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/token")
public class TokenController {

    private final TokenService tokenService;

    @GetMapping(path = "/{token}")
    public ResponseModel validateToken(@PathVariable("token") String token) {
        return tokenService.validateToken(UUID.fromString(token));
    }

}
