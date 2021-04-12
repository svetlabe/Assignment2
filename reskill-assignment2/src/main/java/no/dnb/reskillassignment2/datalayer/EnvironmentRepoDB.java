package no.dnb.reskillassignment2.datalayer;

import no.dnb.reskillassignment2.model.Environment;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class EnvironmentRepoDB implements EnvironmentsRepository{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Collection<Environment> getAllEnvironments() {
        String jpql = "Select e from Environment e ";
        TypedQuery<Environment> query = entityManager.createQuery(jpql, Environment.class);
        return query.getResultList();
    }

    @Override
    public Environment getEnvironmentById(long id) {
        return entityManager.find(Environment.class, id);
    }

    @Override
    @Transactional
    public void insertEnvironment(Environment environment) throws JdbcSQLIntegrityConstraintViolationException {
        entityManager.persist(environment);

    }

    @Override
    @Transactional
    public boolean updateEnvironment(Environment e) {
        Environment environment = entityManager.find(Environment.class, e.getId());
        environment.setId(e.getId());
        environment.setShortName(e.getShortName());
        environment.setLongName(e.getLongName());

        return false;
    }

    @Override
    public void deleteEnvironment(long id) {
        Environment e = entityManager.find(Environment.class, id);
        entityManager.remove(e);
    }

    @Override
    public Environment getEnvironmentByShortName(String shortname){
        Environment environment = entityManager.createQuery(
                "SELECT e from Environment e WHERE e.shortName = :shortName", Environment.class).
                setParameter("shortName", shortname).getSingleResult();
        return environment;
    }



}
