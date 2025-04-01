package com.example.springtododevelop.repository;

import com.example.springtododevelop.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface UserRepository extends JpaRepository<Users, Long> {

    default Users findByUserIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "해당 id (" + id + ")를 가진 유저가 없습니다."));

    }

    default boolean checkPasswordMatchByUserId(Users user, String password) {
        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                "비밀번호가 일치하지 않습니다.");
        }

        return true;
    }

}
