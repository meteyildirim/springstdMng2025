package com.sms.demo.controller.user;

import com.sms.demo.payload.request.user.UserRequest;
import com.sms.demo.payload.response.businnes.ResponseMessage;
import com.sms.demo.payload.response.user.UserResponse;
import com.sms.demo.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save/{userRole}")
    public ResponseEntity<ResponseMessage<UserResponse>> saveUser(
            @RequestBody @Valid UserRequest userRequest,
            // path deki userRole kullanir ve asagidaki userRole atar
            @PathVariable String userRole) {

        return ResponseEntity.ok(userService.saveUser(userRequest, userRole));

    }

}
