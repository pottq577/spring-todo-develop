package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.users.UserResponseDto;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(String username, String password, String email) {

        Users user = new Users(username, password, email);
        Users createdUser = userRepository.save(user);

        return new UserResponseDto(
            createdUser.getUserId(),
            createdUser.getUsername(),
            createdUser.getEmail(),
            createdUser.getCreatedAt(),
            createdUser.getUpdatedAt());

    }

}
