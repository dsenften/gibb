package gibb.inheritance;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 22:16
 */
public class Engineer extends Employee {

    private String discipline = "Computer Science";

    Engineer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return super.toString() + "\n\t" +
                "Engineer{" +
                "discipline='" + discipline + '\'' +
                '}';
    }
}
