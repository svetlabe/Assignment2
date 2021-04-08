package no.dnb.reskillassignment2.service;

import no.dnb.reskillassignment2.datalayer.AdministratorRepository;
import no.dnb.reskillassignment2.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;


@Service
public class AdministratorRepoDB {



  @Autowired
  AdministratorRepository administratorRepository;



    public Collection<Administrator> getAllAdministrators() {
        return (List<Administrator>) administratorRepository.findAll();
    }


    public Administrator getAdministratorByUserName(String username) {
        return administratorRepository.findByUsername(username);
    }


    public void insertAdministrator(Administrator administrator) {
        administratorRepository.save(administrator);
    }


    public void updateAdministrator(Administrator a) {
        Administrator administrator = administratorRepository.findByUsername(a.getUserId());
        if(administrator == null){
            insertAdministrator(a);
        } else {
            administrator.setUserId(a.getUserId());
            administrator.setPassword(a.getPassword());
            administrator.setRole("admin");
        }
    }


    public void deleteAdministrator(String userId) {
        Administrator a = administratorRepository.findByUsername(userId);
        if(a == null){
            return;
        } else {
            administratorRepository.delete(a);
        }
    }
}
