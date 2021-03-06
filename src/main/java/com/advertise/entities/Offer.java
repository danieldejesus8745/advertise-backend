package com.advertise.entities;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Entity(name = "offers")
public class Offer {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 30)
    private String price;

    @Column(nullable = false)
    private UUID owner;

    @Column(nullable = false)
    private UUID post;

    @Column(nullable = false)
    private LocalDate createdAt;

}
