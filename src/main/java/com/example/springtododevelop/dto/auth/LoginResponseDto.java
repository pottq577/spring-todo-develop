package com.example.springtododevelop.dto.auth;

import com.example.springtododevelop.entity.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginResponseDto {

    private final String email;
    private final String password;

    public static LoginResponseDto toDto(Users users) {
        return new LoginResponseDto(
            users.getEmail(),
            users.getPassword()
        );
    }

}
