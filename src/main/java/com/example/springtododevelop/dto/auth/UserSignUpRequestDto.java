package com.example.springtododevelop.dto.auth;

import com.example.springtododevelop.entity.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSignUpRequestDto {

    private final String username;
    private final String password;
    private final String email;

    public static UserSignUpRequestDto toDto(Users users) {
        return new UserSignUpRequestDto(
            users.getUsername(),
            users.getPassword(),
            users.getEmail()
        );
    }

}
