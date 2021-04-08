package no.dnb.reskillassignment2.security;

/*import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class JwtTokenFilter extends GenericFilterBean {
    private static final String BEARER = "Bearer";
    private AdminUserDetailsService adminDetailsServise;

    public JwtTokenFilter(AdminUserDetailsService adminDetailsServise) {
        this.adminDetailsServise = adminDetailsServise;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        //Check for Authorization:Bearer JWT
        String headerValue = ((HttpServletRequest)req).getHeader("Authorization");
        getBearerToken(headerValue).ifPresent(token-> {
            //Pull the Username and Roles from the JWT to construct the user details
            adminDetailsServise.loadUserByJwtToken(token).ifPresent(userDetails -> {
                //Add the user details (Permissions) to the Context for just this API invocation
                SecurityContextHolder.getContext().setAuthentication(
                        new PreAuthenticatedAuthenticationToken(userDetails, "", userDetails.getAuthorities()));
            });
        });

        //move on to the next filter in the chains
        filterChain.doFilter(req, res);
    }

    private Optional<String> getBearerToken(String headerVal) {
        if (headerVal != null && headerVal.startsWith(BEARER)) {
            return Optional.of(headerVal.replace(BEARER, "").trim());
        }
        return Optional.empty();
    }
}


 */