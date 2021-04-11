package no.dnb.reskillassignment2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ENVIRONMENTS")
public class Environment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id = -1;
    @Column (name = "shortname", unique = true)
    private String shortName;
    @Column (name = "longname")
    private String longName;

    @OneToMany(mappedBy="environment", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<ConfigurationData> configurationData;


    // Lage en liste over alle environments (destinations - se review)
    // Koble referanse mot configuration data
    // tidsstempel
    public Environment(String shortName, String longName){
        this.shortName = shortName;
        this.longName = longName;
        configurationData = new ArrayList<>();
    }

}
