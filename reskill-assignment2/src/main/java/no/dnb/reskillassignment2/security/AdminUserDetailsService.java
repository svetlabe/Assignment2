package no.dnb.reskillassignment2.security;
/*
import no.dnb.reskillassignment2.datalayer.AdministratorRepository;
import no.dnb.reskillassignment2.model.Administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Component
public class AdminUserDetailsService implements UserDetailsService {
    private AdministratorRepository adminrepository;

    @Autowired
    JwtProvider jwtProvider;

    public AdminUserDetailsService(AdministratorRepository adminrepository) {
        this.adminrepository = adminrepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator admin = adminrepository.getAdministratorByUserName(username);
        if(admin == null){
            throw new UsernameNotFoundException("Cannot find username : " + username);
        }
        return new  AdminAuthenticationDetails (admin);
    }

    public Optional<UserDetails> loadUserByJwtToken(String jwtToken) {
        if (jwtProvider.isValidToken(jwtToken)) {
            return Optional.of(
                    withUsername(jwtProvider.getUsername(jwtToken))
                            .authorities(jwtProvider.getRoles(jwtToken))
                            .password("") //token does not have password but field may not be empty
                            .accountExpired(false)
                            .accountLocked(false)
                            .credentialsExpired(false)
                            .disabled(false)
                            .build());
        }
        return Optional.empty();
    }
}


*/