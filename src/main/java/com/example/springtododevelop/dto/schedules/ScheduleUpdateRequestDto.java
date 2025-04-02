package com.example.springtododevelop.dto.schedules;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleUpdateRequestDto {

    private final String password;
    private final String title;
    private final String contents;

}
