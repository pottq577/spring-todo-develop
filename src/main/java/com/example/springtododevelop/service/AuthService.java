package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.auth.UserSignUpResponseDto;
import com.example.springtododevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public UserSignUpResponseDto signup(Long userId) {
        return null;
    }

}
