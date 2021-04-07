package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface AdministratorRepository {
    //Create, Read, Update, Delete

    Collection<Administrator> getAllAdministrators();
    Administrator getAdministratorByUserName(String username);
    void insertAdministrator(Administrator administrator);
    void updateAdministrator(Administrator administrator);
    void deleteAdministrator(String userId);


}
