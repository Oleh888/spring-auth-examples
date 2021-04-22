package study.spring.security.security;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class AuthenticationLoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        log.info("Successfully authenticated request with id: " + httpRequest.getHeader("request-id"));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
