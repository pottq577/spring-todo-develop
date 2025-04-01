package com.example.springtododevelop.controller;

import com.example.springtododevelop.dto.users.UserCreateRequestDto;
import com.example.springtododevelop.dto.users.UserCreateResponseDto;
import com.example.springtododevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserCreateResponseDto> createUser(
        @RequestBody UserCreateRequestDto requestDto) {

        UserCreateResponseDto userCreateResponseDto =
            userService.createUser(
                requestDto.getUsername(),
                requestDto.getPassword(),
                requestDto.getEmail()
            );

        return new ResponseEntity<>(userCreateResponseDto, HttpStatus.CREATED);

    }

}
