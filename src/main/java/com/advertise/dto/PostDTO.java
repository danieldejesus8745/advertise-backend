package com.advertise.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class PostDTO {

    private UUID uuid;
    private String title;
    private String description;
    private UUID owner;
    private LocalDate createdAt;
    private String city;
    private String state;

}
