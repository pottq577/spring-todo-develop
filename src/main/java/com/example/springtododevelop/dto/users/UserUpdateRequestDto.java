package com.example.springtododevelop.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserUpdateRequestDto {

    @NotEmpty
    @Size(max = 15)
    private final String username;

    @NotEmpty
    @Size(min = 8, max = 20)
    private final String oldPassword;

    @NotEmpty
    @Size(min = 8, max = 20)
    private final String newPassword;

    @NotBlank
    @Email
    private final String email;

}
