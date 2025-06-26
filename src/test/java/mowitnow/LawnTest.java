package mowitnow;

import mowitnow.coordinate.Position;
import mowitnow.mower.Lawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LawnTest {

    @Test
    public void isIn() {
        Lawn lawn = new Lawn(5, 5);
        assertTrue(lawn.in(Position.at(3, 3)));
        assertTrue(lawn.in(Position.at(5, 5)));
    }

    @Test
    public void isOutside() {
        Lawn lawn = new Lawn(5, 5);
        assertFalse(lawn.in(Position.at(-1, 3)));
        assertFalse(lawn.in(Position.at(10, 5)));
    }
}
