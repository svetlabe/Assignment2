package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.Enviroment;
import no.dnb.reskillassignment2.Enviroment;

import java.util.Collection;


public interface EnvironmentsRepository {
    //Create, Read, Update, Delete

    Collection<Enviroment> getAllEnvironments();
    Enviroment getEnvironmentById(long id);
    Enviroment insertEnvironment(Enviroment environment);
    boolean updateEnvironment(Enviroment environment);
    boolean deleteEnvironment(long id);
}
