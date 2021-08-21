package com.cme.validator.entities;

import lombok.Data;

import java.util.List;

@Data
public class UserDetails {

    private long id;
    private String userName;
    private List<UserInput> userInput;
}
