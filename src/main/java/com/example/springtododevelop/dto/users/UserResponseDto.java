package com.example.springtododevelop.dto.users;

import com.example.springtododevelop.entity.Users;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponseDto {

    private final Long userId;
    private final String username;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static UserResponseDto toDto(Users users) {
        return new UserResponseDto(
            users.getUserId(),
            users.getUsername(),
            users.getEmail(),
            users.getCreatedAt(),
            users.getUpdatedAt()
        );
    }

}
