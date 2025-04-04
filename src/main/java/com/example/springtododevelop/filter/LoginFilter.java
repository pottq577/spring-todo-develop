package com.example.springtododevelop.filter;

import com.example.springtododevelop.exception.ExceptionCode;
import com.example.springtododevelop.handler.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class LoginFilter extends OncePerRequestFilter {

    private static final String[] WHITE_LIST = {"/auth/login", "/api/users"};
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        // 회원가입, 로그인 시 필터 제외
        if (isWhiteList(requestURI, method)) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            ErrorResponse errorResponse = ErrorResponse.of(ExceptionCode.NOT_LOGIN_ERROR,
                "로그인이 필요합니다.");

            response.setStatus(errorResponse.getStatus());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("UTF-8");

            objectMapper.writeValue(response.getWriter(), errorResponse);
            return;
        }

        filterChain.doFilter(request, response);

    }

    private boolean isWhiteList(String requestURI, String method) {

        if (requestURI.equals("/api/users") && method.equals("POST")) {
            return true;
        }
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }

}
