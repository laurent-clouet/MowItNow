package mowitnow;

import mowitnow.coordinate.Orientation;
import mowitnow.coordinate.Position;
import mowitnow.mower.Lawn;
import mowitnow.mower.Mower;
import mowitnow.processing.strategy.ForwardStrategy;
import mowitnow.processing.strategy.RotateLeftStrategy;
import mowitnow.processing.strategy.RotateRightStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerActionTest {

    @Test
    public void rotateLeft() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(Position.at(2, 4), Orientation.EAST);

        RotateLeftStrategy action = new RotateLeftStrategy(lawn, mower, new ArrayList<>());

        action.execute();

        assertEquals(Position.at(2, 4), mower.getPosition()); // mower didn't move forward
        assertEquals(Orientation.NORTH, mower.getOrientation()); // mower has actually rotated
    }

    @Test
    public void rotateRight() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(Position.at(2, 4), Orientation.EAST);

        RotateRightStrategy action = new RotateRightStrategy(lawn, mower, new ArrayList<>());

        action.execute();

        assertEquals(Position.at(2, 4), mower.getPosition()); // mower didn't move forward
        assertEquals(Orientation.SOUTH, mower.getOrientation()); // mower has actually rotated
    }

    @Test
    public void forward() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(Position.at(2, 2), Orientation.EAST);

        ForwardStrategy action = new ForwardStrategy(lawn, mower, new ArrayList<>());

        action.execute();

        assertEquals(Position.at(3, 2), mower.getPosition()); // mower has moved forward
        assertEquals(Orientation.EAST, mower.getOrientation()); // mower has not rotated
    }

    @Test
    public void forwardOutside() {
        // the mower can not move because the target will be outside the lawn

        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(Position.at(5, 2), Orientation.EAST);

        ForwardStrategy action = new ForwardStrategy(lawn, mower, new ArrayList<>());

        action.execute();

        assertEquals(Position.at(5, 2), mower.getPosition()); // mower has NOT moved forward
        assertEquals(Orientation.EAST, mower.getOrientation()); // mower has not rotated
    }

    @Test
    public void forwardTaken() {
        // the mower can not move because another mower is on the target position

        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(Position.at(2, 2), Orientation.EAST);
        List<Mower> mowerOthers = new ArrayList<>();
        mowerOthers.add(new Mower(Position.at(3, 2), Orientation.EAST));

        ForwardStrategy action = new ForwardStrategy(lawn, mower, mowerOthers);

        action.execute();

        assertEquals(Position.at(2, 2), mower.getPosition()); // mower has NOT moved forward
        assertEquals(Orientation.EAST, mower.getOrientation()); // mower has not rotated
    }
}
