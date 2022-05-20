package com.advertise.controllers;

import com.advertise.services.TokenService;
import com.advertise.utils.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/token")
public class TokenController {

    private final TokenService tokenService;

    @GetMapping
    public ResponseModel validateToken(@RequestHeader("Authorization") String token) {
        return tokenService.validateToken(UUID.fromString(token));
    }

}
