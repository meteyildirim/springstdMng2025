package com.sms.demo.payload.request.user;

import com.sms.demo.payload.request.abstracts.BaseUserRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class UserRequest extends BaseUserRequest {
}
