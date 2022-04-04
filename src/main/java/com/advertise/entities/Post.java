package com.advertise.entities;

import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String postDesc;

    @Column(nullable = false)
    private UUID owner;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Transient
    private String city;

    @Transient
    private String state;

}
