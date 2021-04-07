package no.dnb.reskillassignment2.controllers;

import no.dnb.reskillassignment2.model.Administrator;
import no.dnb.reskillassignment2.datalayer.AdministratorRepository;
import no.dnb.reskillassignment2.datalayer.ConfigurationDataRepository;
import no.dnb.reskillassignment2.datalayer.EnvironmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
    @RequestMapping("/environment")
    @CrossOrigin

    public class ControllerAdmin {

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    ConfigurationDataRepository configurationDataRepository;

    @Autowired
    EnvironmentsRepository environmentsRepository;

    /*

    o	Edit the description for an existing environment.
o	Add a new environment.
o	Add, edit, or delete an item of configuration data.
o	View configuration data modifications within a specified timeframe.

     */

    //get all admins
    @GetMapping(value = "/", produces = {"application/json"})
    public ResponseEntity<Collection<Administrator>> getAllAdministrators(){
        Collection<Administrator> administrators = administratorRepository.getAllAdministrators();

        return ResponseEntity.ok().body(administrators);
    }

    //get one admin
    @GetMapping(value = "/{username}", produces = {"application/json"})
    public ResponseEntity<Administrator> getAdministratorByUserName(@PathVariable String username){
        Administrator a = administratorRepository.getAdministratorByUserName(username);
        if (a==null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok().body(a);
        }
    }


}
