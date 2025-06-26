package mowitnow.processing.strategy;

import mowitnow.coordinate.Position;
import mowitnow.mower.Lawn;
import mowitnow.mower.Mower;

import java.util.List;


/**
 * Move forward (do not move if a another mower is taken the next position or if it's outside of the lawn)
 */
public class ForwardStrategy extends MowerInstructionStrategy {
    public ForwardStrategy(Lawn lawn, Mower mower, List<Mower> otherMowers) {
        super(lawn, mower, otherMowers);
    }

    @Override
    public void execute() {
        Position target;
        target = futureForward(mower);

        // 1st check if we are inside the lawn
        // them check if there is no other mower on the target
        if (lawn.in(target)) {
            boolean taken = otherMowers.stream().anyMatch(aMower -> aMower.getPosition().equals(target));
            if (!taken) {
                mower.setPosition(target);
            }
            //else {
            // do nothing, another mower is on the target position
            //}
        }
        //else {
        // is outside the lawn: do nothing
        //}
    }

    private Position futureForward(Mower mower) {
        int x = 0, y = 0;
        switch (mower.getOrientation()) {
            case NORTH:
                x = mower.getPosition().getX();
                y = mower.getPosition().getY() + 1;
                break;
            case EAST:
                x = mower.getPosition().getX() + 1;
                y = mower.getPosition().getY();
                break;
            case SOUTH:
                x = mower.getPosition().getX();
                y = mower.getPosition().getY() - 1;
                break;
            case WEST:
                x = mower.getPosition().getX() - 1;
                y = mower.getPosition().getY();
                break;
        }
        return Position.at(x, y);
    }
}
