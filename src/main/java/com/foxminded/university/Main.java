package com.foxminded.university;

import com.foxminded.university.config.SpringConfig;
import com.foxminded.university.util.TableCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {

    public static void main( String[] args ) throws IOException {

        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(SpringConfig.class);

        TableCreator tableCreator = context.getBean(TableCreator.class);

        tableCreator.createTables();
        tableCreator.fillInData();
    }
}
