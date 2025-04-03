package com.example.springtododevelop.controller;

import com.example.springtododevelop.dto.schedules.ScheduleDeleteRequestDto;
import com.example.springtododevelop.dto.schedules.ScheduleRequestDto;
import com.example.springtododevelop.dto.schedules.ScheduleResponseDto;
import com.example.springtododevelop.dto.schedules.ScheduleUpdateRequestDto;
import com.example.springtododevelop.service.ScheduleService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 일정 생성을 요청하는 메소드
     *
     * @param requestDto 유저 식별자가 포함된 클라이언트 요청 {@link ScheduleRequestDto} 객체
     * @return 생성이 완료된 일정 정보가 담긴 {@link ScheduleResponseDto} 객체
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(
        @RequestBody @Valid ScheduleRequestDto requestDto
    ) {

        ScheduleResponseDto scheduleResponseDto =
            scheduleService.createSchedule(
                requestDto.getUserId(),
                requestDto.getTitle(),
                requestDto.getContents()
            );

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);

    }

    /**
     * 전체 일정 조회를 요청하는 메소드
     *
     * @return 일정 정보가 담긴 {@link ScheduleResponseDto} 객체 리스트
     */
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAllSchedules();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);

    }

    /**
     * 일정 식별자에 해당하는 일정을 찾도록 요청하는 메소드
     *
     * @param scheduleId 일정 식별자
     * @return 일정 식별자에 해당하는 일정 정보가 담긴 {@link ScheduleResponseDto} 객체
     */
    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long scheduleId) {
        return new ResponseEntity<>(scheduleService.findById(scheduleId), HttpStatus.OK);
    }

    /**
     * 일정 식별자에 해당하는 일정을 수정하도록 요청하는 메소드
     *
     * @param scheduleId 일정 식별자
     * @param requestDto 클라이언트 요청 {@link ScheduleRequestDto} 객체
     * @return 수정이 완료된 일정 정보가 담긴 {@link ScheduleRequestDto} 객체
     */
    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
        @PathVariable Long scheduleId,
        @RequestBody @Valid ScheduleUpdateRequestDto requestDto
    ) {

        ScheduleResponseDto updatedSchedule = scheduleService.updateSchedule(
            scheduleId, requestDto.getPassword(), requestDto.getTitle(), requestDto.getContents()
        );

        return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);

    }

    /**
     * 일정 식별자에 해당하는 일정을 삭제하도록 요청하는 메소드
     *
     * @param scheduleId 일정 식별자
     * @param requestDto 클라이언트 요청 {@link ScheduleDeleteRequestDto} 객체
     * @return 성공 시 200 OK 반환
     */
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(
        @PathVariable Long scheduleId,
        @RequestBody ScheduleDeleteRequestDto requestDto
    ) {

        scheduleService.deleteSchedule(scheduleId, requestDto.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
