package no.dnb.reskillassignment2;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Data
@Entity

public class Enviroment {
    @OneToMany
}
