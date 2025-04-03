package com.example.springtododevelop.filter;

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

    private static final String[] WHITE_LIST = {"/auth/login", "/api/users/create"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
        throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();

        // 회원가입, 로그인 시 필터 제외
        if (isWhiteList(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인을 해주세요.");
            return;
        }

        filterChain.doFilter(request, response);

    }

    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }

}
