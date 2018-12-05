package gibb.interfaces;

import lombok.ToString;

/**
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 22:44
 */
@ToString
public class Schindler implements ElevatorController {

    private int destinationLevel;

    @Override
    public void floor(int level) {
        this.destinationLevel = level;
    }

    @Override
    public void openDoor() {
        // TODO Replace auto generated code
    }

    @Override
    public void closeDoor() {
        // TODO Replace auto generated code
    }

}
