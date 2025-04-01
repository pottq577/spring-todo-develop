package com.example.springtododevelop.controller;

import com.example.springtododevelop.dto.users.UserRequestDto;
import com.example.springtododevelop.dto.users.UserResponseDto;
import com.example.springtododevelop.dto.users.UserUpdateRequestDto;
import com.example.springtododevelop.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 생성을 요청하는 메소드
     *
     * @param requestDto 사용자 요청 {@link UserRequestDto} 객체
     * @return 유저 정보가 담긴 {@link UserResponseDto} 객체
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(
        @RequestBody UserRequestDto requestDto) {

        UserResponseDto userResponseDto =
            userService.createUser(
                requestDto.getUsername(),
                requestDto.getPassword(),
                requestDto.getEmail()
            );

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);

    }

    /**
     * 전체 유저 조회를 요청하는 메소드
     *
     * @return 유저 정보가 담긴 {@link UserResponseDto} 객체 리스트
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {

        List<UserResponseDto> users = userService.findAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(
        @PathVariable Long userId,
        @RequestBody UserUpdateRequestDto requestDto
    ) {

        UserResponseDto updatedUser = userService.updateUser(userId, requestDto.getUsername(),
            requestDto.getOldPassword(),
            requestDto.getNewPassword(), requestDto.getEmail());

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

}
