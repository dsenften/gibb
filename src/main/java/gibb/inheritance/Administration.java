package gibb.inheritance;

import lombok.Getter;
import lombok.Setter;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 22:28
 */
public class Administration extends Employee {

    @Getter
    @Setter
    private Double salary;

    public Administration(String firstName, String lastName) {
        super(firstName, lastName);
    }

}
