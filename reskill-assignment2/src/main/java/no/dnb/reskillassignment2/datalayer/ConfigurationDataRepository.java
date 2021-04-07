package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.model.ConfigurationData;

import java.util.Collection;


public interface ConfigurationDataRepository {
    //Create, Read, Update, Delete

    Collection<ConfigurationData> getAllConfigurations();
    ConfigurationData getConfigurationById(long id);
    void insertConfiguration(ConfigurationData configuration);
    void updateConfiguration(ConfigurationData configuration);
    void deleteConfiguration(long id);
}
