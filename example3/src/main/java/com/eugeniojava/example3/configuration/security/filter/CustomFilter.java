package com.eugeniojava.example3.configuration.security.filter;

import com.eugeniojava.example3.configuration.security.authentication.CustomAuthentication;
import com.eugeniojava.example3.configuration.security.authentication.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@AllArgsConstructor
public class CustomFilter extends OncePerRequestFilter {
    private final CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        var key = request.getHeader("key");
        var customAuthentication = new CustomAuthentication(false, key);
        var authentication = customAuthenticationManager.authenticate(customAuthentication);
        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request, response);
        }
    }
}
