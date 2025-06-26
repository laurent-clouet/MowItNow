package mowitnow.io.parser;

import mowitnow.mower.Instruction;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Parse a string to get an Instruction list
 */
public class InstructionParser implements Parser<String, Queue<Instruction>> {


    @Override
    public Queue<Instruction> parse(final String source) {
        Queue<Instruction> instructions = new LinkedList<Instruction>();
        for (char instruction : source.toCharArray()) {
            switch (instruction) {
                case 'G':
                    instructions.add(Instruction.ROTATE_LEFT);
                    break;
                case 'D':
                    instructions.add(Instruction.ROTATE_RIGHT);
                    break;
                case 'A':
                    instructions.add(Instruction.FORWARD);
                    break;
                default:
                    throw new IllegalArgumentException("Invalide instruction '" + instruction + ", source: '" + source + "'");
            }
        }
        return instructions;
    }
}
