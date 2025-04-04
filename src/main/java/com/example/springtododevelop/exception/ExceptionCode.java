package com.example.springtododevelop.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {
    // 유저
    PASSWORD_INVALID(403, "USER_001", "비밀번호가 일치하지 않습니다."),
    USER_NOT_FOUND(404, "USER_002", "유저 정보를 찾을 수 없습니다."),
    EMAIL_NOT_FOUND(404, "USER_003", "이메일이 존재하지 않습니다."),

    // 일정
    SCHEDULE_NOT_FOUND(404, "SCHEDULE_001", "일정 정보를 찾을 수 없습니다."),

    // 공통
    NOT_LOGIN_ERROR(401, "AUTH_001", "로그인을 먼저 해주세요."),
    NOT_VALID_ERROR(400, "G011", "Validation Exception 발생");

    private final int status;
    private final String code;
    private final String message;

}
