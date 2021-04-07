package no.dnb.reskillassignment2.datalayer;


import no.dnb.reskillassignment2.model.ConfigurationData;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public boolean updateConfiguration(ConfigurationData configuration) {

        return false;
    }

    @Override
    public boolean deleteConfiguration(long id) {

        return false;
    }
}
