package gibb.inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 2018-12-12, 11:12
 */
class PointTest {

    @Test
    void getX() {
        double expected = 1.23;
        Point point = new Point(expected, 3.45);

        assertEquals(expected, point.getX());
    }

    @Test
    void getY() {
    }

    @Test
    void tString() {
    }

    @Test
    void setX() {
    }

    @Test
    void setY() {
    }
}