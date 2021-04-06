package no.dnb.reskillassignment2;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="ADMINISTRATORS")
public class Administrator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id = -1;

    private String userId;
    private String password;


    @JsonManagedReference



}
