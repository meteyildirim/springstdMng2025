package com.sms.demo.payload.request.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseUserRequest extends    AbstractUserRequest{
    // superbuilder sayesinde extend yapabiliyoruz

    @NotNull
    @Size(min = 8, max = 20, message = "your password should be 2-20 chars")
    private String password;

    private Boolean buildIn = false;
}
