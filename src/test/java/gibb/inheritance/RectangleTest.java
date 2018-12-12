package gibb.inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RectangleTest {

   private final double WIDTH = 123.456;
   private final double HEIGHT = 13.779;

   private final double X = 3.14159;
   private final double Y = 7.95;

   private Rectangle rectangle;
   private Point point;

   @BeforeEach
   void setUp() {
      point = new Point(X, Y);
      rectangle = new Rectangle(point, WIDTH, HEIGHT);
   }

   @Test
   void testNegativeYCoordinates() {
      org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
               point.setY(-5);
            });
   }

   @Test
   void testNegativeXCoordinates() {
      org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
               point.setX(-5);
            });
   }

   @Test
   void getHeight() {
      double expected = 45.9;
      rectangle.setHeight(expected);
      assertEquals(expected, rectangle.getHeight());
   }

   @Test
   void setWidth() {
      double expected = 45.9;
      rectangle.setWidth(expected);
      assertEquals(expected, rectangle.getWidth());
   }

   @Test
   void testToString() {
      String expected = "Rectangle(super=Shape(point=Point(x=3.14159, y=7.95), rectangle=null), width=123.456, height=13.779)";
      assertEquals(expected, rectangle.toString());
   }
}