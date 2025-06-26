package mowitnow;

import mowitnow.io.parser.InstructionParser;
import mowitnow.mower.Instruction;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionParserTest {

    @Test
    public void parse() {
        InstructionParser instructionParser = new InstructionParser();
        Queue<Instruction> list = instructionParser.parse("GGAD");

        assertEquals(4, list.size());
    }

}
