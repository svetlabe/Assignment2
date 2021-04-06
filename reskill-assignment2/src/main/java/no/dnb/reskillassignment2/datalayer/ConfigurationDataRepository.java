package no.dnb.reskillassignment2.datalayer;



import no.dnb.reskillassignment2.ConfigurationData;
import no.dnb.reskillassignment2.ConfigurationData;

import java.util.Collection;


public interface ConfigurationDataRepository {
    //Create, Read, Update, Delete

    Collection<ConfigurationData> getAllConfigurations();
    ConfigurationData getConfigurationById(long id);
    ConfigurationData insertConfiguration(ConfigurationData configuration);
    boolean updateConfiguration(ConfigurationData configuration);
    boolean deleteConfiguration(long id);
}
