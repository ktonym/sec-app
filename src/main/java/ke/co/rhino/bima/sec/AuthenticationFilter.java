package ke.co.rhino.bima.sec;

import ke.co.rhino.bima.sec.service.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        Authentication auth = AuthenticationService.getAuthentication((HttpServletRequest) req);
        SecurityContextHolder.getContext().setAuthentication(auth);
        chain.doFilter(req,res);
    }
}
