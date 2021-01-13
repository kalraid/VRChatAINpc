package com.dnd.project.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(2)
public class ApiAccessLogFilter extends OncePerRequestFilter {
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    	
    	log.info(" Access URI : "+request.getRequestURI());
        filterChain.doFilter(request, response);
    }
}
