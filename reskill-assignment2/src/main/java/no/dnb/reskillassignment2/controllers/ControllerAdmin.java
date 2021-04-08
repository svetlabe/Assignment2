package no.dnb.reskillassignment2.controllers;

import no.dnb.reskillassignment2.model.Administrator;
import no.dnb.reskillassignment2.datalayer.AdministratorRepository;
import no.dnb.reskillassignment2.datalayer.ConfigurationDataRepository;
import no.dnb.reskillassignment2.datalayer.EnvironmentsRepository;
import no.dnb.reskillassignment2.model.ConfigurationData;
import no.dnb.reskillassignment2.model.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;


@RestController
    @RequestMapping("/admin")
    @CrossOrigin

    public class ControllerAdmin {

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    ConfigurationDataRepository configurationDataRepository;

    @Autowired
    EnvironmentsRepository environmentsRepository;

    private final String SUPER_SECRET_TOKEN = "secret-token";


    // TODO: 07.04.2021 :  View configuration data modifications within a specified timeframe.

    @PostMapping("/login")
    public ResponseEntity<Administrator> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        Administrator user = administratorRepository.getAdministratorByUserName(username);
        if (user != null) {
            if (user.getPassword().equalsIgnoreCase(pwd)) {
                user.setToken(SUPER_SECRET_TOKEN);
                return ResponseEntity.ok().body(user);
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
   //get all admins
    @GetMapping(value = "/admins", produces = {"application/json"})
    public ResponseEntity<Collection<Administrator>> getAllAdministrators(){
        Collection<Administrator> administrators = administratorRepository.getAllAdministrators();

        return ResponseEntity.ok().body(administrators);
    }




    //get all environments
    @GetMapping(value = "/environments", produces = {"application/json"})
    public ResponseEntity<Collection<Environment>> getAllEnvironments(){
        Collection<Environment> environments = environmentsRepository.getAllEnvironments();

        return ResponseEntity.ok().body(environments);
    }

    //update environment (edit description)
    @PutMapping(value="/environments/{id}", consumes={"application/json"})
    public ResponseEntity<Void> updateEnvironment(@PathVariable int id, @RequestBody Environment environment) {
        if (!environmentsRepository.updateEnvironment(environment))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }

    //add environment
    @PostMapping(
            value="/environments",
            consumes={"application/json"},  // if via html form: "application/x-www-form-urlencoded"},
            produces={"application/json"})
    public void insertEnvironment(@RequestBody Environment environment) {
        environmentsRepository.insertEnvironment(environment);
    }





    //get all configurationData
    @GetMapping(value = "/configurationdata", produces = {"application/json"})
    public ResponseEntity<Collection<ConfigurationData>> getAllConfigurations(){
        Collection<ConfigurationData> configurationdata = configurationDataRepository.getAllConfigurations();

        return ResponseEntity.ok().body(configurationdata);
    }

    //get single configurationData
    @GetMapping(value = "/configurationdata/{id}", produces = {"application/json"})
    public ResponseEntity<ConfigurationData> getConfigurationById(@PathVariable long id){
        ConfigurationData c = configurationDataRepository.getConfigurationById(id);
        if (c==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok().body(c);
        }
    }

    //edit configurationData
    @PutMapping(value="/configurationdata/{id}", consumes={"application/json"})
    public ResponseEntity<Void> updateConfiguration(@PathVariable long id, @RequestBody ConfigurationData configuration) {
        if (!configurationDataRepository.updateConfiguration(configuration))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }

    //add configurationData
    @PostMapping(
            value="/configurationdata",
            consumes={"application/json"},  // if via html form: "application/x-www-form-urlencoded"},
            produces={"application/json"})
    public void insertConfiguration(@RequestBody ConfigurationData configuration) {

        configurationDataRepository.insertConfiguration(configuration);
    }

    @DeleteMapping("/configurationdata/{id}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable long id) {
        if (!configurationDataRepository.deleteConfiguration(id))
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().build();
    }

    // trenger vi en valideringsmetode eller vi kan sende alt gjennom login?

}
