package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.Administrator;

import java.util.Collection;


public interface AdministratorRepository {
    //Create, Read, Update, Delete

    Collection<Administrator> getAllAdministrators();
    Administrator getAdministratorByUserName(String username);
    void insertAdministrator(Administrator administrator);
    void updateAdministrator(Administrator administrator);
    void deleteAdministrator(long id);
}
