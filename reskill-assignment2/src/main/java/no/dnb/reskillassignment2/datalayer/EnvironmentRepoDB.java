package no.dnb.reskillassignment2.datalayer;

import no.dnb.reskillassignment2.Administrator;
import no.dnb.reskillassignment2.Environment;
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
    public void insertEnvironment(Environment environment) {
        entityManager.persist(environment);

    }

    @Override
    @Transactional
    public void updateEnvironment(Environment e) {
        Environment environment = entityManager.find(Environment.class, e.getId());
        environment.setId(e.getId());
        environment.setName(e.getName());
        environment.setDescription(e.getDescription());

    }

    @Override
    public void deleteEnvironment(long id) {
        Environment e = entityManager.find(Environment.class, id);
        entityManager.remove(e);
    }
}
