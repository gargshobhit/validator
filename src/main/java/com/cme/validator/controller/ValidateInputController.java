package com.cme.validator.controller;

import com.cme.validator.dto.UserRequest;
import com.cme.validator.dto.UserResponse;
import com.cme.validator.entities.UserDetails;
import com.cme.validator.entities.UserInput;
import com.cme.validator.exception.InvalidInputException;
import com.cme.validator.service.Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping(path="/api")
@RequiredArgsConstructor
public class ValidateInputController {

    private final ModelMapper modelMapper;
    private final Service service;

    @PostMapping(value="validate", produces="application/json", consumes="application/json")
    public ResponseEntity<?> createRecord(@RequestBody UserRequest input) throws InvalidInputException {
        service.createRecord((toUserInput(input)));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="hello", produces="application/json", consumes="application/json")
    public String hello() throws InvalidInputException {

        return "Hello World";
    }

    private UserDetails toUserInput(UserRequest input) {
        final UserDetails userDetails = modelMapper.map(input, UserDetails.class);
        final UserInput userInput = new UserInput();
        userDetails.setUserName(input.getUserName());
        userInput.setValue(input.getValue());
        userDetails.setUserInput(Arrays.asList(userInput));

        return userDetails;
    }
}
