package com.foxminded.university.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class TableCreator {

    private static final String PATH_TO_THE_SCHEMA = "src/main/resources/schema.sql";
    private static final String PATH_TO_THE_DATA = "src/main/resources/data.sql";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    TableCreator(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createTables() throws IOException {
        StringBuilder queryBuilder = new StringBuilder();
        Files.lines(Paths.get(PATH_TO_THE_SCHEMA)).forEach(queryBuilder::append);

        jdbcTemplate.execute(queryBuilder.toString());
    }

    public void fillInData() throws IOException {
        StringBuilder queryBuilder = new StringBuilder();
        Files.lines(Paths.get(PATH_TO_THE_DATA)).forEach(queryBuilder::append);

        jdbcTemplate.execute(queryBuilder.toString());
    }
}
