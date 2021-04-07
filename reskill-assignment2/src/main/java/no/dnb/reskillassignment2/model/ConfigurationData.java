
package no.dnb.reskillassignment2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name="CONFIGURATIONDATA")
public class ConfigurationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1;

    private String name;
    private String version;
    private String date;

    @ManyToOne
    @JoinColumn(name="ENVIRONMENT_ID")
    @JsonBackReference
    private Environment environment;


    public ConfigurationData() {
    }

    public ConfigurationData(long id, String name, String version, String date) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.date = date;
    }

    public ConfigurationData(String name, String version, String date) {
        this(-1, name, version, date);
    }

    //Koble sammen med environment - bruk Andys review pattern.
}
