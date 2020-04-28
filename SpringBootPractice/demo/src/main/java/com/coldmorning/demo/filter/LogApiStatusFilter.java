package com.coldmorning.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogApiStatusFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Logger logger = LoggerFactory.getLogger(getClass());
        filterChain.doFilter(request, response);
        getStatus(request,response);
    }

    private  void getStatus(HttpServletRequest request, HttpServletResponse response){
         String httpStatus = String.valueOf(response.getStatus());
         String httpMethod = String.valueOf(request.getMethod());
        logger.info("[httpStatus] " + httpStatus);
        logger.info("[httpMethod] " + httpMethod);
    }


}
