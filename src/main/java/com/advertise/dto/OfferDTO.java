package com.advertise.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class OfferDTO {

    private UUID uuid;
    private String description;
    private String price;
    private UUID owner;
    private UUID post;
    private LocalDate createdAt;

}
