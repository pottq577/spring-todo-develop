package com.example.springtododevelop.dto.schedules;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleUpdateRequestDto {

    private final String password;

    @Size(max = 10)
    private final String title;
    
    private final String contents;

}
