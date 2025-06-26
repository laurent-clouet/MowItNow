package mowitnow.coordinate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Pair for a cartesian coordinate system
 */
@AllArgsConstructor(staticName = "at")
@Data
public class Position {

    private final int x;

    private final int y;
}
