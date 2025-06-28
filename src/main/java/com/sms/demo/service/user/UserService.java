package com.sms.demo.service.user;

import com.sms.demo.payload.request.user.UserRequest;
import com.sms.demo.payload.response.businnes.ResponseMessage;
import com.sms.demo.payload.response.user.UserResponse;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserService {
    public ResponseMessage<UserResponse> saveUser(UserRequest userRequest, String userRole) {
        // validate unique properties


    }
}
