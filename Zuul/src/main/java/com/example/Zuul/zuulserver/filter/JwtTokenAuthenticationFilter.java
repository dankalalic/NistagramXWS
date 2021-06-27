package com.example.Zuul.zuulserver.filter;


import com.example.Zuul.zuulserver.HttpRequestWrapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        HttpRequestWrapper reqWrapper = new HttpRequestWrapper(httpServletRequest);
        String header = httpServletRequest.getHeader("Authorization");

        if(header == null || !header.startsWith("Bearer ")){
            reqWrapper.addHeader("Username","");
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String jwt = header.replace("Bearer ", "");

        try{

            Claims claims = Jwts.parser().setSigningKey("somesecret".getBytes())
                                .parseClaimsJws(jwt).getBody();

            String username = claims.getSubject();

            reqWrapper.addHeader("Username",username);

            if(username != null) {
                List<String> authorities = (List<String>)claims.get("authorities");

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                );

                SecurityContextHolder.getContext().setAuthentication(auth);

            }

            httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, HEAD, PATCH, PUT");
            httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");


        }catch (Exception e){
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(reqWrapper, httpServletResponse);
    }
}
