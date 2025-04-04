package com.example.springtododevelop.handler;

import com.example.springtododevelop.exception.BusinessException;
import com.example.springtododevelop.exception.ExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 비즈니스 로직의 예외처리(Unchecked Exception 발생시 처리)
    @ExceptionHandler(BusinessException.class) // 만들어준 커스텀익셉션 발생시 처리해주는 곳
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {

        log.error("Business Exception Error", ex);

        final ErrorResponse errorResponse = ErrorResponse.of(
            ex.getExceptionCode(), ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorResponse.getStatus()));

    }

    // @valid 유효성 검증에 실패했을 경우 발생하는 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException ex) {

        log.error("handleMethodArgumentNotValidException", ex);

        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder stringBuilder = new StringBuilder();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            stringBuilder.append(fieldError.getField()).append(":");
            stringBuilder.append(fieldError.getDefaultMessage());
            stringBuilder.append(", ");
        }

        final ErrorResponse response = ErrorResponse.of(
            ExceptionCode.NOT_VALID_ERROR, String.valueOf(stringBuilder));

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));

    }


}
