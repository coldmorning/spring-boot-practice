package com.coldmorning.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogProcessTimeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Logger logger = LoggerFactory.getLogger(getClass());
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(request, response);
        long processTime = System.currentTimeMillis() - startTime;

        logger.info("[Time] "+ String.valueOf(processTime) +" ms");

    }
}
