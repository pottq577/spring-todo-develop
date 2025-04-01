package com.example.springtododevelop.dto.users;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDeleteRequestDto {

    private final String password;

}
