package com.example.springtododevelop.dto.auth;

import com.example.springtododevelop.entity.Users;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserSignUpResponseDto {

    private final Long userId;
    private final String username;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static UserSignUpResponseDto toDto(Users users) {
        return new UserSignUpResponseDto(
            users.getUserId(),
            users.getUsername(),
            users.getEmail(),
            users.getCreatedAt(),
            users.getUpdatedAt()
        );
    }

}
