package com.advertise.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
public class PostDTO {

    private UUID id;
    private String title;
    private String postDesc;
    private UUID owner;
    private LocalDateTime createdAt;
    private String city;
    private String state;

}
