package mowitnow.processing.strategy;

import lombok.AllArgsConstructor;
import mowitnow.mower.Lawn;
import mowitnow.mower.Mower;

import java.util.List;

/**
 * Mower are moved/rotated though instruction.
 */
@AllArgsConstructor
public abstract class MowerInstructionStrategy {
    protected Lawn lawn;
    protected Mower mower;
    protected List<Mower> otherMowers;

    public abstract void execute();
}
