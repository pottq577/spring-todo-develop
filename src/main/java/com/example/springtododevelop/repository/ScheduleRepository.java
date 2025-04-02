package com.example.springtododevelop.repository;

import com.example.springtododevelop.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

    default Schedules findByScheduleIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "해당 id (" + id + ")를 가진 일정이 없습니다."));

    }

}
