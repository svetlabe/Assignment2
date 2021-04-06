package no.dnb.reskillassignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeedDb {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {

        jdbcTemplate.update(
                "insert into ADMINISTRATORS (userId, password) values (?,?)",
                new Object[]{"Svetlana", "hei"});

        jdbcTemplate.update(
                "insert into ADMINISTRATORS (userId, password) values (?,?)",
                new Object[]{"Knut", "hei"});

        jdbcTemplate.update(
                "insert into ADMINISTRATORS (userId, password) values (?,?)",
                new Object[]{"Arild", "hei"});



        jdbcTemplate.update(
                "insert into CONFIGURATIONDATA (environment, version, date) values (?,?, ?)",
                new Object[]{"DEV", "XC90", "230974"});

        jdbcTemplate.update(
                "insert into CONFIGURATIONDATA (environment, version, date) values (?,?, ?)",
                new Object[]{"TEST", "XC90", "141577"});

        jdbcTemplate.update(
                "insert into CONFIGURATIONDATA (environment, version, date) values (?,?, ?)",
                new Object[]{"PROD", "Taycan", "230788"});



        jdbcTemplate.update(
                "insert into ENVIRONMENTS (shortName, longName) values (?,?)",
                new Object[]{"DEV", "This is the development envrionment"});

        jdbcTemplate.update(
                "insert into ENVIRONMENTS (shortName, longName) values (?,?)",
                new Object[]{"TEST", "This is the test envrionment"});
        jdbcTemplate.update(
                "insert into ENVIRONMENTS (shortName, longName) values (?,?)",
                new Object[]{"PROD", "This is the production envrionment"});


    }




}
