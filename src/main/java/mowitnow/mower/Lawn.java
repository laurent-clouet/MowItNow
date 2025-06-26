package mowitnow.mower;

import lombok.AllArgsConstructor;
import mowitnow.coordinate.Position;
import lombok.EqualsAndHashCode;
import lombok.Getter;


/**
 * A lawn is a grid
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode()
public class Lawn {
    private int xMax;
    private int yMax;


    /**
     * Is the position inside the lawn ?
     */
    public boolean in(final Position position) {
        return position.getX() <= xMax && position.getX() >= 0 && position.getY() <= yMax && position.getY() >= 0;
    }

    @Override
    public String toString() {
        return "Lawn(x: " + xMax + ", y: " + yMax + ")";
    }
}
