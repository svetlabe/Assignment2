package no.dnb.reskillassignment2.datalayer;


import no.dnb.reskillassignment2.ConfigurationData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class ConfigurationDataRepoDB implements ConfigurationDataRepository{


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Collection<ConfigurationData> getAllConfigurations() {
        return null;
    }

    @Override
    public ConfigurationData getConfigurationById(long id) {
        return null;
    }

    @Override
    public void insertConfiguration(ConfigurationData configuration) {

    }

    @Override
    public void updateConfiguration(ConfigurationData configuration) {

    }

    @Override
    public void deleteConfiguration(long id) {

    }
}
