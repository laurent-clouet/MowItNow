package mowitnow.io.parser;

import mowitnow.coordinate.Orientation;
import mowitnow.coordinate.Position;
import mowitnow.mower.Mower;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Parse a string to get a Mower Object
 */
public class MowerParser implements Parser<String, Mower> {
    private static final String SEPARATOR = " ";
    private static final String PATTERN = "^\\d+ \\d+ [N|E|W|S]$";

    @Override
    public Mower parse(final String source) {
        if (!source.matches(PATTERN)) {
            throw new IllegalArgumentException("Missing information for parsing mower");
        }

        List<String> fields = Arrays.stream(source.split(SEPARATOR)).collect(Collectors.toList());

        // first coordinate them orientation
        int x = Integer.parseInt(fields.get(0));
        int y = Integer.parseInt(fields.get(1));
        Orientation orientation = Orientation.byCode(fields.get(2));

        return new Mower(Position.at(x, y), orientation);
    }
}
