package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.schedules.ScheduleResponseDto;
import com.example.springtododevelop.entity.Schedules;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.repository.ScheduleRepository;
import com.example.springtododevelop.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    /**
     * 일정 생성을 담당하는 메소드
     *
     * @param userId   유저 식별자 id
     * @param title    일정 제목
     * @param contents 일정 내용
     * @return 유저 식별자가 포함된 일정 정보가 담긴 {@link ScheduleResponseDto} 객체
     */
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


    /**
     * DB에 저장된 모든 일정을 조회하는 메소드
     *
     * @return 저장된 일정 정보가 담겨있는 {@link ScheduleResponseDto} 객체 리스트
     */
    public List<ScheduleResponseDto> findAllSchedules() {

        List<Schedules> schedulesList = scheduleRepository.findAll();
        List<ScheduleResponseDto> scheduleResponseDtoList = new ArrayList<>();

        for (Schedules schedules : schedulesList) {
            scheduleResponseDtoList.add(
                new ScheduleResponseDto(
                    schedules.getUser().getUserId(),
                    schedules.getScheduleId(),
                    schedules.getTitle(),
                    schedules.getContents(),
                    schedules.getCreatedAt(),
                    schedules.getUpdatedAt()
                )
            );
        }

        return scheduleResponseDtoList;

    }

}
