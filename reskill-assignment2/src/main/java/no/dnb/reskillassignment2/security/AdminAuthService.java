package no.dnb.reskillassignment2.security;
/*
import no.dnb.reskillassignment2.datalayer.AdministratorRepoDB;
import no.dnb.reskillassignment2.model.Administrator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService implements UserDetailsService {
    private final AdministratorRepoDB adminrepository;

    public AdminAuthService(AdministratorRepoDB adminrepository) {
        super();
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
}
*/