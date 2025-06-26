package mowitnow.mower;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import mowitnow.processing.MowerAction;

import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Scheduler to run simulation
 */
@Getter
@AllArgsConstructor
public class Runner {

    @NonNull
    private final Lawn lawn;

    @NonNull
    final List<Mower> mowers;

    public void run() {
        for (Mower mower : mowers) {
            mow(mower);
        }
    }

    private void mow(final Mower mower) {
        @NonNull Queue<Instruction> instructions = mower.getInstructions();
        if (!instructions.isEmpty()) {
            while (!instructions.isEmpty()) {
                Instruction instruction = instructions.poll();
                MowerAction mowerAction = new MowerAction(lawn, mower, otherMower(mowers, mower));

                mowerAction.execute(instruction);
            }
        }
    }

    public List<Mower> otherMower(List<Mower> mowers, Mower mowerToRemove) {
        return mowers.stream()
                .filter(mower -> !mower.equals(mowerToRemove)) // actually remove the object
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Monitor(lawn: " + lawn.getXMax() + "x" + lawn.getYMax() + " mowers: [" + mowers.stream().map(Object::toString).collect(Collectors.joining(", ")) + "])";
    }
}
