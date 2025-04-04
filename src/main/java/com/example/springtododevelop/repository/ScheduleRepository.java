package com.example.springtododevelop.repository;

import com.example.springtododevelop.entity.Schedules;
import com.example.springtododevelop.exception.BusinessException;
import com.example.springtododevelop.exception.ExceptionCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

    default Schedules findByScheduleIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
            () -> new BusinessException(ExceptionCode.SCHEDULE_NOT_FOUND));

    }

}
