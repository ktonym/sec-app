package ke.co.rhino.bima.sec;

import com.fasterxml.jackson.databind.ObjectMapper;
import ke.co.rhino.bima.sec.model.AccountCredentials;
import ke.co.rhino.bima.sec.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter(String url, AuthenticationManager manager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(manager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res)
            throws AuthenticationException, IOException {

        AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(),
                AccountCredentials.class);
        return getAuthenticationManager().
                authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
                        creds.getPassword(), Collections.emptyList()));

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                            FilterChain chain, Authentication auth) {
        AuthenticationService.addToken(res,auth.getName());
    }
}
