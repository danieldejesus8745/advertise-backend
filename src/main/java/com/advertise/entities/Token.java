package com.advertise.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "tokens")
public class Token {

    @Id
    @GeneratedValue
    private UUID uuid;
    private long expiration;
    private UUID owner;
    private LocalDate createdAt;

}
