package com.advertise.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseModel {

    private int status;
    private String message;
    private Object body;

    public ResponseModel(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
