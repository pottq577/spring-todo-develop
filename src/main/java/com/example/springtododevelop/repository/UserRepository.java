package com.example.springtododevelop.repository;

import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.exception.BusinessException;
import com.example.springtododevelop.exception.ExceptionCode;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    default Users findByUserIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
            () -> new BusinessException(ExceptionCode.USER_NOT_FOUND));

    }

    Optional<Users> findUserByEmail(String email);

    default Users findByEmailOrElseThrow(String email) {
        return findUserByEmail(email).orElseThrow(
            () -> new BusinessException(ExceptionCode.EMAIL_NOT_FOUND));
    }

}
