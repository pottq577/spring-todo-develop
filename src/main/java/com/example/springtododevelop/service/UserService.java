package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.auth.LoginResponseDto;
import com.example.springtododevelop.dto.users.UserResponseDto;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.exception.BusinessException;
import com.example.springtododevelop.exception.ExceptionCode;
import com.example.springtododevelop.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return UserResponseDto.toDto(userRepository.save(new Users(username, password, email)));
    }

    /**
     * DB에 저장된 모든 유저를 찾는 메소드
     *
     * @return 저장된 유저 정보가 담겨있는 {@link UserResponseDto} 객체 리스트
     */
    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAll().stream()
            .map(UserResponseDto::toDto)
            .collect(Collectors.toList());
    }

    /**
     * DB에서 userId 와 일치하는 유저 조회를 담당하는 메소드
     *
     * @param userId 클라이언트 요청 유저 식별자
     * @return 조회된 유저 정보가 담겨있는 {@link UserResponseDto} 객체
     */
    public UserResponseDto findById(Long userId) {
        return UserResponseDto.toDto(userRepository.findByUserIdOrElseThrow(userId));
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
    public UserResponseDto updateUser(Long userId, String username, String oldPassword,
        String newPassword, String email) {

        Users findUser = userRepository.findByUserIdOrElseThrow(userId);
        validateUserPassword(findUser, oldPassword);

        if (username != null) {
            findUser.setUsername(username);
        }
        if (newPassword != null) {
            findUser.setPassword(newPassword);
        }
        if (email != null) {
            findUser.setEmail(email);
        }

        return UserResponseDto.toDto(findUser);

    }

    /**
     * DB에서 userId와 일치하는 유저 삭제를 담당하는 메소드
     *
     * @param userId   유저 식별자
     * @param password 클라이언트 요청 객체의 비밀번호
     */
    @Transactional
    public void deleteUser(Long userId, String password) {

        Users findUser = userRepository.findByUserIdOrElseThrow(userId);
        validateUserPassword(findUser, password);

        userRepository.deleteById(userId);

    }

    /**
     * DB에서 email 과 일치하는 유저를 찾는 메소드
     *
     * @param email    유저 이메일
     * @param password 유저 비밀번호
     * @return 조회된 유저 정보가 담겨있는 {@link LoginResponseDto} 객체
     */
    public LoginResponseDto findByEmail(String email, String password) {

        Users user = userRepository.findByEmailOrElseThrow(email);
        validateUserPassword(user, password);

        return LoginResponseDto.toDto(user);

    }

    /**
     * 유저의 비밀번호가 요청 비밀번호와 같은지 검증하는 메소드
     *
     * @param user     유저 정보가 담긴 {@link Users} 객체
     * @param password 클라이언트 요청 비밀번호
     */
    public void validateUserPassword(Users user, String password) {
        if (!user.getPassword().equals(password)) {
            throw new BusinessException(ExceptionCode.PASSWORD_INVALID);
        }
    }

}
