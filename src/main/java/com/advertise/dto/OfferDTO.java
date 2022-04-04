package com.advertise.dto;

import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class OfferDTO {

    private UUID id;
    private String offerDesc;
    private String price;
    private UUID owner;
    private UUID post;
    private LocalDate createdAt;

}
