package no.dnb.reskillassignment2.datalayer;

import no.dnb.reskillassignment2.Administrator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class AdministratorRepoDB implements AdministratorRepository{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Collection<Administrator> getAllAdministrators() {
        String jpql = "Select a from Administrator a ";
        TypedQuery<Administrator> query = entityManager.createQuery(jpql, Administrator.class);
        return query.getResultList();
    }

    @Override
    public Administrator getAdministratorByUserName(String username) {
        return entityManager.find(Administrator.class, username);
    }

    @Override
    @Transactional
    public void insertAdministrator(Administrator administrator) {
        entityManager.persist(administrator);
    }

    @Override
    public void updateAdministrator(Administrator a) {
        Administrator administrator = entityManager.find(Administrator.class, a.getUserId());
        administrator.setUserId(a.getUserId());
        administrator.setPassword(a.getPassword());
    }

    @Override
    public void deleteAdministrator(String userId) {
        Administrator a = entityManager.find(Administrator.class, userId);
        entityManager.remove(a);
    }
}