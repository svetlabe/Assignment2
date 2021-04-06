package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.Environment;

import java.util.Collection;


public interface EnvironmentsRepository {
    //Create, Read, Update, Delete

    Collection<Environment> getAllEnvironments();
    Environment getEnvironmentById(long id);
    void insertEnvironment(Environment environment);
    void updateEnvironment(Environment environment);
    void deleteEnvironment(long id);
}
