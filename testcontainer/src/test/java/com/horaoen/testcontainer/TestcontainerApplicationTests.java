package com.horaoen.testcontainer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Testcontainers
class TestcontainerApplicationTests {
    private JedisPool pool;
    
    @Container
    @SuppressWarnings("rawtypes")
    public GenericContainer redis = new GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
            .withExposedPorts(6379);

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void setUp() {
        pool = new JedisPool(redis.getHost(), redis.getFirstMappedPort());
    }

    @Test
    public void testSimplePutAndGet() {
        Jedis jedis = pool.getResource();
        jedis.set("hello", "world");
        assertEquals("world", jedis.get("hello"));
    }

}
