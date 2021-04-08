package no.dnb.reskillassignment2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="ADMINISTRATORS")
public class Administrator {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id = -1;

    @Column(name = "userid")
    private String userId;
    private String password;
    private String role;

    @Transient // Prevents the variable from being stored in database
    private String token;



    public Administrator() {
    }

    public Administrator(String userId, String password) {
        this(-1, userId, password );
    }

    public Administrator(long id, String userId, String password) {
        this.id = id;
        this.userId = userId;
        this.password = password;
    }


}
