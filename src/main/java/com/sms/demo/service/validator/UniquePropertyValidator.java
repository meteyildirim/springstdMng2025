package com.sms.demo.service.validator;

import com.sms.demo.exception.ConflictException;
import com.sms.demo.payload.messages.ErrorMessage;
import com.sms.demo.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniquePropertyValidator {

    private final UserRepository userRepository;

    public void checkDuplication(
            String username,
            String ssn,
            String phone,
            String email){
        if(userRepository.existByUsername(username)){
            throw new ConflictException(String.format(ErrorMessage.ALREADY_REGISTER_MESSAGE_USERNAME,username));
        }
        if(userRepository.existsByEmail(username)){
            throw new ConflictException(String.format(ErrorMessage.ALREADY_REGISTER_MESSAGE_EMAIL,username));
        }
        if(userRepository.existsByPhoneNumber(username)){
            throw new ConflictException(String.format(ErrorMessage.ALREADY_REGISTER_MESSAGE_PHONE_NUMBER,username));
        }
        if(userRepository.existsBySsn(username)){
            throw new ConflictException(String.format(ErrorMessage.ALREADY_REGISTER_MESSAGE_SSN,username));
        }

    }
}
