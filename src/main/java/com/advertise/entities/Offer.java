package com.advertise.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "offers")
public class Offer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String offerDesc;

    @Column(nullable = false, length = 30)
    private String price;

    @Column(nullable = false)
    private Short owner;

    @Column(nullable = false)
    private Short post;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
