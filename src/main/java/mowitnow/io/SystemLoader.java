package mowitnow.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import lombok.NonNull;
import lombok.SneakyThrows;

import mowitnow.io.parser.InstructionParser;
import mowitnow.io.parser.LawnParser;
import mowitnow.io.parser.MowerParser;
import mowitnow.mower.Instruction;
import mowitnow.mower.Lawn;
import mowitnow.mower.Runner;
import mowitnow.mower.Mower;

/**
 * Load data to generate a Runner
 */
public class SystemLoader {

    @SneakyThrows(IOException.class)
    public Runner fromFile(final File file) {
        return fromLines(Files.readAllLines(file.toPath(), StandardCharsets.UTF_8));
    }

    public Runner fromLines(@NonNull final List<String> pLines) {
        if (pLines.size() <= 2) {
            throw new IllegalArgumentException("Missing data on file");
        }

        Iterator<String> lines = pLines.iterator();
        LawnParser lawnParser = new LawnParser();
        InstructionParser instructionParser = new InstructionParser();
        Lawn lawn = lawnParser.parse(lines.next());
        MowerParser mowerParser = new MowerParser();
        List<Mower> mowers = new ArrayList<>();
        while (lines.hasNext()) {
            Mower mower = mowerParser.parse(lines.next());
            Queue<Instruction> instructions = instructionParser.parse(lines.next());
            mower.setInstructions(instructions);
            mowers.add(mower);
        }
        return new Runner(lawn, mowers);
    }
}
