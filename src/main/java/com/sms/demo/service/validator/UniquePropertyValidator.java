package com.sms.demo.service.validator;

import com.sms.demo.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniquePropertyValidator {

    private final UserRepository userRepository;

    public void checkDuplication( String username, String ssn, String phone, String email){
        
    }
}
