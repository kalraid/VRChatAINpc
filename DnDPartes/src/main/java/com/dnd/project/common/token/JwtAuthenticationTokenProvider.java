package com.dnd.project.common.token;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class JwtAuthenticationTokenProvider implements AuthenticationTokenProvider {
 
    // 보통 설정파일에 관리하고 `@Value` 등으로 주입받아 사용하는 것을 추천
	@Value("${dnd.secret.key}")
    private String SECRET_KEY;
	
    private static final long EXPIRATION_MS = 1000 * 60 * 60 * 24; 
 
    @Override
    public String parseTokenString(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
 
    @Override
    public JwtAuthenticationToken issue(Long userKey) {
        return JwtAuthenticationToken.builder().token(buildToken(userKey)).build();
    }
 
    // JWT 토큰 생성
    private String buildToken(Long userKey) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiredAt = now.plus(EXPIRATION_MS, ChronoUnit.MILLIS);
        return Jwts.builder()
                .setSubject(String.valueOf(userKey))
                .setIssuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(expiredAt.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
 
    @Override
    public Long getTokenOwnerNo(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        
        return Long.parseLong(claims.getSubject());
    }
 
    @Override
    public boolean validateToken(String token) {
        if (!StringUtils.isEmpty(token)) {
            try {
                Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
                return true;
            } catch (SignatureException e) {
                log.error("Invalid JWT signature", e);
            } catch (MalformedJwtException e) {
                log.error("Invalid JWT token", e);
            } catch (ExpiredJwtException e) {
                log.error("Expired JWT token", e);
            } catch (UnsupportedJwtException e) {
                log.error("Unsupported JWT token", e);
            } catch (IllegalArgumentException e) {
                log.error("JWT claims string is empty.", e);
            }
        }
        return false;
    }
}