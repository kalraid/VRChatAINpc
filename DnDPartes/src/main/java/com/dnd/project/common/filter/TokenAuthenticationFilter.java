package com.dnd.project.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dnd.project.common.exception.ForbiddenException;
import com.dnd.project.common.token.AuthenticationTokenProvider;
import com.dnd.project.common.user.repository.CmUserRepositoryImpl;
import com.dnd.project.common.user.vo.CmUserVo;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private AuthenticationTokenProvider authenticationTokenProvider;
 
    @Autowired
    private CmUserRepositoryImpl cmUserRepositoryImpl;
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = authenticationTokenProvider.parseTokenString(request);
        if (authenticationTokenProvider.validateToken(token)) {
            Long CmUserVoNo = authenticationTokenProvider.getTokenOwnerNo(token);
            try {
            	CmUserVo member = CmUserVo.builder().userKey(CmUserVoNo).build();
                member = cmUserRepositoryImpl.selectUser(member);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member.getId(),
                        member.getPassword());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (UsernameNotFoundException e) {
                throw new ForbiddenException("유효하지않은 인증토큰 입니다. 인증토큰 회원 정보 오류");
            }
        }
        filterChain.doFilter(request, response);
    }
}
