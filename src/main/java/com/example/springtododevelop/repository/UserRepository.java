package com.example.springtododevelop.repository;

import com.example.springtododevelop.entity.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UserRepository extends JpaRepository<Users, Long> {

    default Users findByUserIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "해당 id (" + id + ")를 가진 유저가 없습니다."));

    }

    Optional<Users> findUserByEmail(String email);

    default Users findByEmailOrElseThrow(String email) {
        return findUserByEmail(email).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "이메일이 존재하지 않습니다.")
        );
    }

}
