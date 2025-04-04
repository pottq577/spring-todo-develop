package com.example.springtododevelop.dto.schedules;

import com.example.springtododevelop.entity.Schedules;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleRequestDto {

    private final Long userId;
    
    @Size(max = 10)
    private final String title;

    private final String contents;

    public static ScheduleRequestDto toDto(Schedules schedules) {
        return new ScheduleRequestDto(
            schedules.getUser().getUserId(),
            schedules.getTitle(),
            schedules.getContents()
        );
    }

}
