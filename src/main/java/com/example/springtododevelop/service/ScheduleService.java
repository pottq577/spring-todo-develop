package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.schedules.ScheduleResponseDto;
import com.example.springtododevelop.entity.Schedules;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.repository.ScheduleRepository;
import com.example.springtododevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ScheduleResponseDto createSchedule(Long userId, String title, String contents) {

        Users findUser = userRepository.findByUserIdOrElseThrow(userId);

        Schedules schedule = new Schedules(title, contents);
        schedule.setUser(findUser);

        Schedules createdSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
            createdSchedule.getScheduleId(),
            findUser.getUserId(),
            createdSchedule.getTitle(),
            createdSchedule.getContents(),
            createdSchedule.getCreatedAt(),
            createdSchedule.getUpdatedAt()
        );

    }

}
