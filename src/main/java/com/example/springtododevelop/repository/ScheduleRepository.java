package com.example.springtododevelop.repository;

import com.example.springtododevelop.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

}
