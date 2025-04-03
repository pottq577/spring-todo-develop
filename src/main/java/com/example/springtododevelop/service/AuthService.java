package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.auth.LoginResponseDto;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public LoginResponseDto login(String email, String password) {

        Users findUser = userRepository.findByEmailOrElseThrow(email);

        if (findUser == null) {
            return null;
        }
        validateUserPassword(findUser, password);

        return LoginResponseDto.toDto(findUser);

    }

    private void validateUserPassword(Users user, String password) {
        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비밀번호가 일치하지 않습니다.");
        }
    }

}
