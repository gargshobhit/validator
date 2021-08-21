package com.cme.validator.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserRequest {
    @NonNull
    private String userName;

    @NonNull
    private String value;
}
