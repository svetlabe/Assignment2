package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.model.Environment;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import java.util.Collection;


public interface EnvironmentsRepository {
    //Create, Read, Update, Delete

    Collection<Environment> getAllEnvironments();
    Environment getEnvironmentById(long id);
    void insertEnvironment(Environment environment) throws JdbcSQLIntegrityConstraintViolationException, JdbcSQLIntegrityConstraintViolationException;
    boolean updateEnvironment(Environment environment);
    void deleteEnvironment(long id);
    Environment getEnvironmentByShortName(String shortName);

}
