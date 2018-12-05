package gibb.generics;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 21:29
 */
class CacheTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addString() {

        String expected = "Daniel";
        Cache<String> cache = new Cache<>();
        cache.add(expected);

        assertEquals(expected, cache.get());
    }

    @Test
    void addInteger() {

        Integer expected = 4711;
        Cache<Integer> cache = new Cache<>();
        cache.add(expected);

        assertEquals(expected, cache.get());
    }

    @Test
    void addDouble() {

        Double expected = 3.1415;
        Cache<Double> cache = new Cache<>();
        cache.add(expected);

        assertEquals(expected, cache.get());
    }
}