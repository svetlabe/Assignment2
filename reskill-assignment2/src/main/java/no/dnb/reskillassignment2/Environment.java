package no.dnb.reskillassignment2;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ENVIRONMENTS")
public class Environment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id = -1;
    private String shortName;
    private String longName;

    @Id
    public Long getId() {
        return id;
    }

    public Environment(long id, String shortName, String longName) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
    }


}
