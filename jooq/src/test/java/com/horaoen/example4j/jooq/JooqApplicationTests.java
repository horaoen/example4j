package com.horaoen.example4j.jooq;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootTest
@Testcontainers
@Slf4j
class JooqApplicationTests {
    static Connection connection;
    static DSLContext ctx;

    @Container
    @SuppressWarnings("rawtypes")
    public GenericContainer mysql = new GenericContainer(DockerImageName.parse("mysql:latest"))
            .withExposedPorts(3306);

    @Test
    void contextLoads() {
        String s = ctx.toString();
        System.out.println(s);
    }

    @BeforeClass
    public static void init() throws SQLException {
        log.info("Connecting");
        connection = DriverManager.getConnection(
                System.getProperty("db.url"),
                System.getProperty("db.username"),
                System.getProperty("db.password")
        );

        ctx = DSL.using(connection, SQLDialect.MYSQL);
    }

}
