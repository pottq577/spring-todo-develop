package com.example.springtododevelop.dto.schedules;

import com.example.springtododevelop.entity.Schedules;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleResponseDto {

    private final Long userId;
    private final Long scheduleId;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static ScheduleResponseDto toDto(Schedules schedules) {
        return new ScheduleResponseDto(
            schedules.getUser().getUserId(),
            schedules.getScheduleId(),
            schedules.getTitle(),
            schedules.getContents(),
            schedules.getCreatedAt(),
            schedules.getUpdatedAt()
        );
    }

}
