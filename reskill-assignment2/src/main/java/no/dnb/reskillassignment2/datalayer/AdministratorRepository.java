package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;


public interface AdministratorRepository extends CrudRepository <Administrator, Long> {
    //Create, Read, Update, Delete

    @Query("SELECT a FROM Administrator a WHERE a.userId = ?1")
    Administrator findByUsername(String username);




}
