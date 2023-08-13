package com.horaoen.example4j.jooq;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static com.horaoen.example4j.jooq.database.Tables.AUTHOR;
import static com.horaoen.example4j.jooq.database.Tables.BOOK;


@SpringBootTest
@Slf4j
public class AfterMigrationTests {
    @Autowired
    private DSLContext create;

    @Test
    public void testQueryingAfterMigration() {
        Result<?> result =
                create.select(
                                AUTHOR.FIRST_NAME,
                                AUTHOR.LAST_NAME,
                                BOOK.ID,
                                BOOK.TITLE
                        )
                        .from(AUTHOR)
                        .join(BOOK)
                        .on(AUTHOR.ID.eq(BOOK.AUTHOR_ID))
                        .orderBy(BOOK.ID.asc())
                        .fetch();
        log.info(result.format());
        
    }
}
