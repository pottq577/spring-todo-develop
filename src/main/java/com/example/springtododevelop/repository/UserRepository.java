package com.example.springtododevelop.repository;

import com.example.springtododevelop.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
