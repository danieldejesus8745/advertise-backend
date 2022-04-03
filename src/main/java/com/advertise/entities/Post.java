package com.advertise.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false)
    private String desc;

    @Column(nullable = false)
    private Short owner;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

}
