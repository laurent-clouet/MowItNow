package mowitnow.processing.strategy;

import mowitnow.mower.Lawn;
import mowitnow.mower.Mower;

import java.util.List;

/**
 * Rotate the mower
 */
public class RotateLeftStrategy extends MowerInstructionStrategy {

    public RotateLeftStrategy(Lawn lawn, Mower mower, List<Mower> otherMowers) {
        super(lawn, mower, otherMowers);
    }

    @Override
    public void execute() {
        mower.setOrientation(mower.getOrientation().left());
    }
}
