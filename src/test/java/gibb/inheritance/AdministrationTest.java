package gibb.inheritance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 22:32
 */
class AdministrationTest {

    private Administration admin;

    @BeforeEach
    void setUp() {
        admin = new Administration("Anna", "Senften");
    }

    @Test
    void setSalary() {
        Double expected = 1234.5678;
        admin.setSalary(expected);
        assertEquals(expected, admin.getSalary());
    }

    @Test
    void getFirstName() {
        String expected = "Anna";
        admin.setFirstName(expected);
        assertEquals(expected, admin.getFirstName());
    }

    @Test
    void getLastName() {
        String expected = "Senften";
        admin.setLastName(expected);
        assertEquals(expected, admin.getLastName());
    }

}