package com.example.springtododevelop.dto.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserCreateRequestDto {

    private final String username;
    private final String password;
    private final String email;

}
