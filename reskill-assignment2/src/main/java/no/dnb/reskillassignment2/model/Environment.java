package no.dnb.reskillassignment2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="ENVIRONMENTS")
public class Environment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id = -1;
    @Column (name = "shortname")
    private String shortName;
    @Column (name = "longname")
    private String longName;




    public Environment() {
    }

    public Environment(String shortName, String longName) {
        this(-1, shortName, longName);
    }

    public Environment(long id, String shortName, String longName) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
    }


}
