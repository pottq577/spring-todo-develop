package com.example.springtododevelop.dto.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRequestDto {

    private final String username;
    private final String password;
    private final String email;

}
