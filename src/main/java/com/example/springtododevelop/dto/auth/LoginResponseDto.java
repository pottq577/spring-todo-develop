package com.example.springtododevelop.dto.auth;

import com.example.springtododevelop.entity.Schedules;
import com.example.springtododevelop.entity.Users;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginResponseDto {

    private final Long userId;
    private final String username;
    private final String password;
    private final String email;
    private final List<Schedules> schedules;

    public static LoginResponseDto toDto(Users users) {
        return new LoginResponseDto(
            users.getUserId(),
            users.getUsername(),
            users.getPassword(),
            users.getEmail(),
            users.getSchedules()
        );
    }

}
