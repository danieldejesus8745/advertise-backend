package com.advertise.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private UUID owner;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Transient
    private String city;

    @Transient
    private String state;

}
