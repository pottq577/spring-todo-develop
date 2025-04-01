package com.example.springtododevelop.controller;

import com.example.springtododevelop.dto.users.UserCreateRequestDto;
import com.example.springtododevelop.dto.users.UserResponseDto;
import com.example.springtododevelop.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<UserResponseDto> createUser(
        @RequestBody UserCreateRequestDto requestDto) {

        UserResponseDto userResponseDto =
            userService.createUser(
                requestDto.getUsername(),
                requestDto.getPassword(),
                requestDto.getEmail()
            );

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {

        List<UserResponseDto> users = userService.findAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

}
