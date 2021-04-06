package no.dnb.reskillassignment2;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity

public class Environment {
    private Long id;



    @Id
    public Long getId() {
        return id;
    }

    @OneToMany
}
