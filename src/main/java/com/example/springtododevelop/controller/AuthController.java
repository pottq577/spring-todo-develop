package com.example.springtododevelop.controller;

import com.example.springtododevelop.dto.auth.UserSignUpRequestDto;
import com.example.springtododevelop.dto.auth.UserSignUpResponseDto;
import com.example.springtododevelop.service.AuthService;
import com.example.springtododevelop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> signup(
        @RequestBody UserSignUpRequestDto requestDto) {

        UserSignUpResponseDto userSignUpResponseDto = authService.signup(1L);

        return new ResponseEntity<>(null, HttpStatus.CREATED);

    }

}
