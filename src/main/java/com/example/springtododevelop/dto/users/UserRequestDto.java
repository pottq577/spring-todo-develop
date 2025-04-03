package com.example.springtododevelop.dto.users;

import com.example.springtododevelop.entity.Users;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRequestDto {

    private final String username;
    private final String password;
    private final String email;

    public static UserRequestDto toDto(Users users) {
        return new UserRequestDto(
            users.getUsername(),
            users.getPassword(),
            users.getEmail()
        );
    }

}
