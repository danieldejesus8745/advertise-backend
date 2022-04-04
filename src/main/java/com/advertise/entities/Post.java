package com.advertise.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

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
    private Short owner;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Transient
    private String city;

    @Transient
    private String state;

}
