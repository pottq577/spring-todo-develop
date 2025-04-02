package com.example.springtododevelop.service;

import com.example.springtododevelop.dto.schedules.ScheduleResponseDto;
import com.example.springtododevelop.entity.Schedules;
import com.example.springtododevelop.entity.Users;
import com.example.springtododevelop.repository.ScheduleRepository;
import com.example.springtododevelop.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserService userService;
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

        return ScheduleResponseDto.toDto(createdSchedule);

    }


    /**
     * DB에 저장된 모든 일정을 조회하는 메소드
     *
     * @return 저장된 일정 정보가 담겨있는 {@link ScheduleResponseDto} 객체 리스트
     */
    public List<ScheduleResponseDto> findAllSchedules() {
        return scheduleRepository.findAll().stream()
            .map(ScheduleResponseDto::toDto)
            .collect(Collectors.toList());
    }

    /**
     * DB에서 scheduleId 와 일치하는 일정을 조회하는 메소드
     *
     * @param scheduleId 클라이언트 요청 일정 식별자
     * @return 조회된 일정 정보가 담겨있는 {@link ScheduleResponseDto} 객체
     */
    public ScheduleResponseDto findById(Long scheduleId) {
        return ScheduleResponseDto.toDto(
            scheduleRepository.findByScheduleIdOrElseThrow(scheduleId));
    }

    /**
     * DB에에서 scheduleId 와 일치하는 일정 정보 수정을 담당하는 메소드
     *
     * @param userId     유저 식별자
     * @param scheduleId 일정 식별자
     * @param title      일정 제목
     * @param contents   일정 내용
     * @return 수정된 일정 정보가 반영된 {@link ScheduleResponseDto} 객체
     */
    @Transactional
    public ScheduleResponseDto updateSchedule(Long scheduleId, String title,
        String contents) {

        Schedules findSchedules = scheduleRepository.findByScheduleIdOrElseThrow(scheduleId);
        Users user = findSchedules.getUser();
        userService.validateUserPassword(user, user.getPassword());

        if (title != null) {
            findSchedules.setTitle(title);
        }
        if (contents != null) {
            findSchedules.setContents(contents);
        }

        scheduleRepository.save(findSchedules);

        return ScheduleResponseDto.toDto(findSchedules);

    }

}
