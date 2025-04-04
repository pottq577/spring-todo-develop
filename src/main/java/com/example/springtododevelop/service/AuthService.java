package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.auth.LoginResponseDto;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.exception.BusinessException;
import com.example.springtododevelop.exception.ExceptionCode;
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
        validateUserPassword(findUser, password);

        return LoginResponseDto.toDto(findUser);

    }

    private void validateUserPassword(Users user, String password) {
        if (!user.getPassword().equals(password)) {
            throw new BusinessException(ExceptionCode.PASSWORD_INVALID);
        }
    }

}
