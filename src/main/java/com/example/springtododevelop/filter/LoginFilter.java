package com.example.springtododevelop.filter;

import com.example.springtododevelop.exception.BusinessException;
import com.example.springtododevelop.exception.ExceptionCode;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.util.PatternMatchUtils;

public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/auth/login", "/api/users"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();

        // 회원가입, 로그인 시 필터 제외
        if (isWhiteList(requestURI, method)) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            throw new BusinessException(ExceptionCode.NOT_LOGIN_ERROR);
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
