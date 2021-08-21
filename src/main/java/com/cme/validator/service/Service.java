package com.cme.validator.service;

import com.cme.validator.entities.UserDetails;
import com.cme.validator.exception.InvalidInputException;
import com.cme.validator.validator.UserInputValidation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class Service {
    private final UserInputValidation userInputValidation;

    public void createRecord(UserDetails userDetails) throws InvalidInputException {
        userInputValidation.validateInputIsPalindrome(userDetails);
        com.cme.validator.repositories.UserDetails.save(userDetails);
    }

}
