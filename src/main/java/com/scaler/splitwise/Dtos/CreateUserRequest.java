package com.scaler.splitwise.Dtos;

import com.scaler.splitwise.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CreateUserRequest {
    private String name;
    private String email;
    private String phone;
    private String password;

    public User toUser()
    {
        return User.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .password(password)
                .build();
    }

}
