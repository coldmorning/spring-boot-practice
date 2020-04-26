package com.coldmorning.demo.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogApiStatusFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);

        String httpStatus = String.valueOf(response.getStatus());
        String httpMethod = request.getMethod();
        String uri = request.getRequestURI();
        String queryParams = request.getQueryString();

        if (queryParams != null) {
            uri += "?" + queryParams;
        }

        System.out.println(String.join("Log:"," ", httpStatus, httpMethod, uri));
    }
}
