package com.sms.demo.payload.request.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sms.demo.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


import javax.validation.constraints.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractUserRequest {

    @NotNull(message = "Please enter username")
    @Size(min=4, max=16, message="Your username should be 4 chars")
    @Pattern(regexp ="\\A(?!\\s*\\Z).+", message = "Your username must consist of the characters .")
    private String username;

    @NotNull(message = "Please enter name")
    @Size(min=4, max=16, message="Your name should be 4 chars")
    @Pattern(regexp ="\\A(?!\\s*\\Z).+", message = "Your name must consist of the characters .")
    private String name;

    @NotNull(message = "Please enter surname")
    @Size(min=4, max=16, message="Your surname should be 4 chars")
    @Pattern(regexp ="\\A(?!\\s*\\Z).+", message = "Your surname must consist of the characters .")
    private String surname;

    @NotNull(message = "Please enter birthday")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past( message = "Your birthday can not be ")
    private LocalDate birthday;

    @NotNull(message="ssn can not be empty")
    @Pattern(regexp="^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$", message = "enter a valid ssn number")
    private String ssn;

    @NotNull(message = "Please enter birthplace")
    @Size(min=2, max=16, message="Your birthplace should be 2 chars")
    @Pattern(regexp ="\\A(?!\\s*\\Z).+", message = "Your birthplace must consist of the characters .")
    private String birthplace;

    @NotNull(message = "Please enter your phone number")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotNull
    private Gender gender;

    @NotNull
    @Email(message="Please enter a valid email")
    private String email;

}
