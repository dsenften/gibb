package gibb.inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 22:20
 */
class EngineerTest {

    @Test
    void constructor() {

        Engineer engineer = new Engineer("Daniel", "Senften");

        String expected = "Employee(firstName=Daniel, lastName=Senften)\n"
              + "\tEngineer{discipline='Computer Science'}";
        assertEquals(expected, engineer.toString());
    }
}