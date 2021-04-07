package no.dnb.reskillassignment2.controllers;


import no.dnb.reskillassignment2.datalayer.ConfigurationDataRepository;
import no.dnb.reskillassignment2.datalayer.EnvironmentsRepository;
import no.dnb.reskillassignment2.model.ConfigurationData;
import no.dnb.reskillassignment2.model.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
@CrossOrigin


public class ControllerPublic {

    @Autowired
    ConfigurationDataRepository configurationDataRepository;

    @Autowired
    EnvironmentsRepository environmentsRepository;



    //get all environments
    @GetMapping(value = "/environments", produces = {"application/json"})
    public ResponseEntity<Collection<Environment>> getAllEnvironments(){
        Collection<Environment> environments = environmentsRepository.getAllEnvironments();

        return ResponseEntity.ok().body(environments);
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




}
