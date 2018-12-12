package gibb.inheritance;

import lombok.ToString;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 2018-12-12, 10:54
 */
@ToString(callSuper = true)
public class Circle extends Shape {

    private double radius;

    public Circle(Point origin, double radius) {
        super.setPoint(origin);
        this.radius = radius;
    }
}
