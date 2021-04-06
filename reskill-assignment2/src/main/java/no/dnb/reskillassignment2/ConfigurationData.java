package no.dnb.reskillassignment2;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


    @Data
    @Entity
    @Table(name = "CONFIGURATIONDATA")
    public class ConfigurationData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id = -1;

        private String environment;
        private String version;
        private String date;

        public ConfigurationData() {
        }

        public ConfigurationData(long id, String environment, String version, String date) {
            this.id = id;
            this.environment = environment;
            this.version = version;
            this.date = date;
        }

        public ConfigurationData(String environment, String version, String date) {
            this.id = -1;
            this.environment = environment;
            this.version = version;
            this.date = date;
        }
    }
