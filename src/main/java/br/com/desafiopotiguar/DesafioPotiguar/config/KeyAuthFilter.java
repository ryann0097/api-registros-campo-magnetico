package br.com.desafiopotiguar.DesafioPotiguar.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KeyAuthFilter implements Filter {
    @Value("${spring.api.auth-key}")
    private String expectedKey;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        if("POST".equalsIgnoreCase(httpReq.getMethod()) &&
                httpReq.getRequestURI().startsWith("/medicoes")){
            String apiKey = httpReq.getHeader("X-API-KEY");
            if(apiKey == null || !apiKey.equals((expectedKey))){
                httpRes.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpRes.getWriter().write("Unauthorized");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
