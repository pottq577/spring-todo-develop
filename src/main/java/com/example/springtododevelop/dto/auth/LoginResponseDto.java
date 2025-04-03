package com.example.springtododevelop.dto.auth;

import com.example.springtododevelop.entity.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginResponseDto {

    private final Long userId;
    private final String username;
    private final String password;
    private final String email;

    public static LoginResponseDto toDto(Users users) {
        return new LoginResponseDto(
            users.getUserId(),
            users.getUsername(),
            users.getPassword(),
            users.getEmail()
        );
    }

}
