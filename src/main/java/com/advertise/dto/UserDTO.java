package com.advertise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDTO {

    private Short uuid;
    private String name;
    private String email;
    private String password;
    private String city;
    private String state;
    private LocalDate createdAt;

}
