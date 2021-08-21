package com.cme.validator.validator;

import com.cme.validator.entities.UserDetails;
import com.cme.validator.exception.InvalidInputException;
import org.springframework.stereotype.Component;

@Component
public class UserInputValidation {

    public void validateInputIsPalindrome(UserDetails userDetails) throws InvalidInputException {
        String value = userDetails.getUserInput().get(0).getValue();
        int valueLength = userDetails.getUserInput().get(0).getValue().length();
        int backwardCounter = valueLength - 1;
        for(int i = 0 ;i < valueLength /2 ; i++) {
            if (value.charAt(i) == ' ' || value.charAt(i) != value.charAt(backwardCounter--))
                throw new InvalidInputException("Invalid User value input");
        }
    }
}
