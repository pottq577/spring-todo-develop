package com.example.springtododevelop.dto.users;

import com.example.springtododevelop.entity.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserRequestDto {

    @NotEmpty
    @Size(max = 15)
    private final String username;

    @NotEmpty
    @Size(min = 8, max = 20)
    private final String password;

    @NotBlank
    @Email
    private final String email;

    public static UserRequestDto toDto(Users users) {
        return new UserRequestDto(
            users.getUsername(),
            users.getPassword(),
            users.getEmail()
        );
    }

}
