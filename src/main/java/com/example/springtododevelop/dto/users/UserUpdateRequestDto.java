package com.example.springtododevelop.dto.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserUpdateRequestDto {

    private final String username;
    private final String oldPassword;
    private final String newPassword;
    private final String email;

}
