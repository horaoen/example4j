package com.horaoen.example4j.jooq;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
