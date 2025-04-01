package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.users.UserResponseDto;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 유저 생성을 담당하는 메소드
     *
     * @param username 유저명
     * @param password 비밀번호
     * @param email    이메일
     * @return 새롭게 생성된 유저 정보가 담겨있는 {@link UserResponseDto} 객체
     */
    public UserResponseDto createUser(String username, String password, String email) {

        Users user = new Users(username, password, email);
        Users createdUser = userRepository.save(user);

        return new UserResponseDto(createdUser.getUserId(), createdUser.getUsername(),
            createdUser.getEmail(), createdUser.getCreatedAt(), createdUser.getUpdatedAt());

    }

    /**
     * DB에 저장된 모든 유저를 찾는 메소드
     *
     * @return 저장된 유저 정보가 담겨있는 {@link UserResponseDto} 객체 리스트
     */
    public List<UserResponseDto> findAllUsers() {

        List<Users> user = userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();

        for (Users users : user) {
            userResponseDtoList.add(
                new UserResponseDto(users.getUserId(), users.getUsername(), users.getPassword(),
                    users.getCreatedAt(), users.getUpdatedAt()));
        }

        return userResponseDtoList;

    }

    /**
     * DB에서 userId 와 일치하는 유저 조회를 담당하는 메소드
     *
     * @param userId 클라이언트 요청 유저 식별자
     * @return 조회된 유저 정보가 담겨있는 {@link UserResponseDto} 객체
     */
    public UserResponseDto findById(Long userId) {

        Users findUser = userRepository.findByUserIdOrElseThrow(userId);

        return new UserResponseDto(findUser.getUserId(), findUser.getUsername(),
            findUser.getEmail(), findUser.getCreatedAt(), findUser.getUpdatedAt());

    }

    /**
     * DB에서 userId와 일치하는 유저 정보 수정을 담당하는 메소드
     *
     * @param userId      유저 식별자
     * @param username    변경할 이름
     * @param oldPassword 이전 비밀번호
     * @param newPassword 새로운 비밀번호
     * @param email       변경할 이메일
     * @return 수정된 유저 정보가 반영된 {@link UserResponseDto} 객체
     */
    @Transactional
    public UserResponseDto updateUser(
        Long userId, String username, String oldPassword, String newPassword, String email) {

        Users findUser = userRepository.findByUserIdOrElseThrow(userId);

        if (!findUser.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        if (username != null) {
            findUser.setUsername(username);
        }
        if (newPassword != null) {
            findUser.setPassword(newPassword);
        }
        if (email != null) {
            findUser.setEmail(email);
        }

        userRepository.save(findUser);

        return new UserResponseDto(findUser.getUserId(), findUser.getUsername(),
            findUser.getEmail(), findUser.getCreatedAt(), findUser.getUpdatedAt());

    }

}
