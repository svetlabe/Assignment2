package no.dnb.reskillassignment2.datalayer;

import no.dnb.reskillassignment2.model.Administrator;
import no.dnb.reskillassignment2.model.ConfigurationData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
@Transactional
public class ConfigurationDataRepoDB implements ConfigurationDataRepository{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Collection<ConfigurationData> getAllConfigurations() {
        String jpql = "Select c from ConfigurationData c ";
        TypedQuery<ConfigurationData> query = entityManager.createQuery(jpql, ConfigurationData.class);
        return query.getResultList();
    }

    @Override
    public ConfigurationData getConfigurationById(long id) {
        return entityManager.find(ConfigurationData.class, id);
    }

    @Override
    public void insertConfiguration(ConfigurationData configuration) {
        entityManager.persist(configuration);

    }

    @Override
    // do not allow update of Environment
    public boolean updateConfiguration(ConfigurationData c) {
        ConfigurationData configurationData = entityManager.find(ConfigurationData.class, c.getId());
        if( configurationData != null){
            configurationData.setName(c.getName());
            configurationData.setVersion(c.getVersion());
            configurationData.setDate(c.getDate());
            return true;
        } else{
            return false;
        }

    }

    @Override
    public boolean deleteConfiguration(long id) {
        ConfigurationData c = entityManager.find(ConfigurationData.class, id);
        if(c != null){
            entityManager.remove(c);
            return true;
        } else{
            return false;
        }

    }
}
