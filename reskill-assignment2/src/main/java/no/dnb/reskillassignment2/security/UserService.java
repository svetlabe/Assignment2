package no.dnb.reskillassignment2.security;

/*import no.dnb.reskillassignment2.datalayer.AdministratorRepository;
import no.dnb.reskillassignment2.model.Administrator;
import no.dnb.reskillassignment2.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private AdministratorRepository userRepository;

    private AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;

    private JwtProvider jwtProvider;

    @Autowired
    public UserService(AdministratorRepository userRepository, AuthenticationManager authenticationManager,
                       PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }


    public Optional<String> signin(String username, String password) {
        Optional<String> token = Optional.empty();
        Administrator user = userRepository.getAdministratorByUserName(username);
        if (user!= null) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                token = Optional.of(jwtProvider.createToken(username));
            } catch (AuthenticationException e){

            }
        }
        return token;
    }

}

 */
