package com.example.springtododevelop.dto.users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDeleteRequestDto {

    @NotEmpty
    @Size(min = 8, max = 20)
    private final String password;

}
