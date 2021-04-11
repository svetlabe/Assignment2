package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.model.Environment;

import java.util.Collection;


public interface EnvironmentsRepository {
    //Create, Read, Update, Delete

    Collection<Environment> getAllEnvironments();
    Environment getEnvironmentById(long id);
    void insertEnvironment(Environment environment);
    boolean updateEnvironment(Environment environment);
    void deleteEnvironment(long id);

}
