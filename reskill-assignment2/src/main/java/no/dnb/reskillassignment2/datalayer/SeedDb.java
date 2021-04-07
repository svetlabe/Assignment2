package no.dnb.reskillassignment2.datalayer;

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
                "insert into ADMINISTRATORS (userid, password) values (?,?)",  "Svetlana", "hei");

        jdbcTemplate.update(
                "insert into ADMINISTRATORS (userid, password) values (?,?)",  "Knut", "hei");

        jdbcTemplate.update(
                "insert into ADMINISTRATORS (userid, password) values (?,?)", "Arild", "hei");



        jdbcTemplate.update(
                "insert into ENVIRONMENTS (shortName, longName) values (?,?)",
                new Object[]{"DEV", "This is the development envrionment"});

        jdbcTemplate.update(
                "insert into ENVIRONMENTS (shortName, longName) values (?,?)",
                new Object[]{"TEST", "This is the test envrionment"});
        jdbcTemplate.update(
                "insert into ENVIRONMENTS (shortName, longName) values (?,?)",
                new Object[]{"PROD", "This is the production envrionment"});
        jdbcTemplate.update(
                "insert into ENVIRONMENTS (shortName, longName) values (?,?)",
                new Object[]{"PROD2", "This is the production envrionment for retail banking"});



        jdbcTemplate.update(
                "insert into CONFIGURATIONDATA (environment_id, name, version, date) values (?,?,?,?)",
                new Object[]{1,"Development for cars", "XC90", "230974"});

        jdbcTemplate.update(
                "insert into CONFIGURATIONDATA (environment_id, name,version, date) values (?,?,?,?)",
                new Object[]{2,"TEST for mainframe", "XC90", "141577"});

        jdbcTemplate.update(
                "insert into CONFIGURATIONDATA (environment_id, name, version, date) values (?,?,?,?)",
                new Object[]{3,"PROD for retailbank", "Taycan", "230788"});
    }

}
