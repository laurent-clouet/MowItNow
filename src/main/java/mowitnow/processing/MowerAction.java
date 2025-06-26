package mowitnow.processing;

import lombok.AllArgsConstructor;
import mowitnow.mower.Instruction;
import mowitnow.mower.Lawn;
import mowitnow.mower.Mower;
import mowitnow.processing.strategy.ForwardStrategy;
import mowitnow.processing.strategy.MowerInstructionStrategy;
import mowitnow.processing.strategy.RotateLeftStrategy;
import mowitnow.processing.strategy.RotateRightStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class MowerAction {

    private final Map<Instruction, MowerInstructionStrategy> strategies = new HashMap<>();

    public MowerAction(Lawn lawn, Mower mower, List<Mower> otherMowers) {
        registerStrategy(Instruction.FORWARD, new ForwardStrategy(lawn, mower, otherMowers));
        registerStrategy(Instruction.ROTATE_LEFT, new RotateLeftStrategy(lawn, mower, otherMowers));
        registerStrategy(Instruction.ROTATE_RIGHT, new RotateRightStrategy(lawn, mower, otherMowers));
    }

    public void execute(Instruction instruction) {
        MowerInstructionStrategy strategy = strategies.get(instruction);
        if (strategy != null) {
            strategy.execute();
        }
        //else {
        // TODO: use a proper log system
        // "No strategy registered for instruction: " + instruction
        //}
    }

    private void registerStrategy(Instruction instruction, MowerInstructionStrategy strategy) {
        strategies.put(instruction, strategy);
    }
}
