
package no.dnb.reskillassignment2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="ENVIRONMENT_ID")
    //@JsonBackReference
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
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


}
