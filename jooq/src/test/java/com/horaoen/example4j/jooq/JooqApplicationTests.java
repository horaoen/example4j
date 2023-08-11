package com.horaoen.example4j.jooq;

import com.horaoen.example4j.jooq.database.tables.Author;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RequiredArgsConstructor
class JooqApplicationTests {
    @Autowired
    private DSLContext create;
    @Test
    void contextLoads() {
        assertNotNull(create);
    }
    
    @Test
    void insertOneTest() {
        int inserted = create.insertInto(Author.AUTHOR).values(1, "horaoen", "fhr").execute();
        assertEquals(1, inserted);
        // clean
        int deleted = create.delete(Author.AUTHOR).where(Author.AUTHOR.ID.eq(1)).execute();
        assertEquals(1, deleted);
    }

}
