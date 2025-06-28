package com.sms.demo.payload.response.abstracts;

import com.sms.demo.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BaseUserResponse {
    // Burasi response kismi oldugundan , yani databse den gelen buna validation gerekmez.
    private  Long id;
    private  String username;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String ssn;
    private String birthPlace;
    private String phoneNumber;
    private String email;
    private Gender gender;
    private  String userRole;

}
