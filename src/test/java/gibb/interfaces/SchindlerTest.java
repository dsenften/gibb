package gibb.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 22:50
 */
class SchindlerTest {

    private Schindler elevator;

    @BeforeEach
    void setUp() {
        elevator = new Schindler();
    }

    @Test
    void constructor() {
        String expected = "Schindler(destinationLevel=0)";
        assertEquals(expected, elevator.toString());
    }
}