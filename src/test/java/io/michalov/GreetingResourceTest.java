package io.michalov;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(GreetingResource.class)
public class GreetingResourceTest {

    private final String PREEXISTING_ID = "random-string";


    @Inject
    GreetingResource resource;

    @BeforeEach
    public void before() {
        resource.put(PREEXISTING_ID);
    }

    @AfterEach
    public void after() {
        resource.delete(PREEXISTING_ID);
    }


    @Test
    public void testGet() {
        Assertions.assertEquals(resource.get(PREEXISTING_ID), new Data(PREEXISTING_ID));
    }

    @Test
    public void testPut() {
        String randomID = "other-random-string";

        Data put = resource.put(randomID);

        Assertions.assertNull(put);
        Assertions.assertEquals(new Data(randomID), resource.get(randomID));
    }
}