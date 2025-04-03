package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.auth.LoginResponseDto;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public LoginResponseDto login(String email, String password) {

        Users findUser = userRepository.findByEmailOrElseThrow(email);

        if (findUser == null) {
            return null;
        }

        return LoginResponseDto.toDto(findUser);

    }

}
