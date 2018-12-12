package gibb.inheritance;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 2018-12-12, 11:01
 */

@Setter
@Getter
@ToString(callSuper = true)
public class Rectangle extends Shape {

    private double width, height;

    public Rectangle(Point origin, double width, double height) {
        super.setPoint(origin);
        this.width = width;
        this.height = height;
    }
}
