package com.horaoen.example4j.jooq;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.horaoen.example4j.jooq.database.tables.Author.AUTHOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class GettingStartedTests {
    @Autowired
    private DSLContext create;

    @Test
    void fetchTest() {
        Result<Record> result = create.select().from(AUTHOR).fetch();
        assertNotNull(result);
    }

    @Test
    void iterateTest() {
        // insert 
        create.insertInto(AUTHOR).values(1, "horaoen", "fhr").execute();
        create.insertInto(AUTHOR).values(2, "horaoen", "FHR").execute();

        // assert
        Result<Record> result = create.select().from(AUTHOR).fetch();
        result.forEach(record -> assertEquals("horaoen", record.getValue(AUTHOR.FIRST_NAME)));

        // clean
        create.delete(AUTHOR).execute();
    }
}
