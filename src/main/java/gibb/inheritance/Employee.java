package gibb.inheritance;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 22:13
 */
@ToString
@Getter
@Setter
public abstract class Employee {


    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
