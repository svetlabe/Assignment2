package no.dnb.reskillassignment2;

import no.dnb.reskillassignment2.datalayer.AdministratorRepository;
import no.dnb.reskillassignment2.datalayer.ConfigurationDataRepository;
import no.dnb.reskillassignment2.datalayer.EnvironmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;


@RestController
    @RequestMapping("/XXXX")  // TODO: 06.04.2021 change XXXX to actual path for website (ex. /destinations)
    @CrossOrigin

    public class ControllerAdmin {

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    ConfigurationDataRepository configurationDataRepository;

    @Autowired
    EnvironmentsRepository environmentsRepository;


    //get all admins
    @GetMapping(value = "/XXXX", produces = {"application/json"})
    public ResponseEntity<Collection<Administrator>> getAllAdministrators(){
        Collection<Administrator> administrators = administratorRepository.getAllAdministrators();

        return ResponseEntity.ok().body(administrators);
    }


}
