package gibb.inheritance;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 2018-12-12, 09:41
 */

@Setter
@Getter
@ToString
public class Point extends Object {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
