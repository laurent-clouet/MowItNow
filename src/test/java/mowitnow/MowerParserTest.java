package mowitnow;

import mowitnow.coordinate.Orientation;
import mowitnow.coordinate.Position;
import mowitnow.io.parser.MowerParser;
import mowitnow.mower.Mower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowerParserTest {

    @Test
    public void parse() {
        MowerParser mowerParser = new MowerParser();
        Mower output = mowerParser.parse("1 2 N");

        assertEquals(new Mower(Position.at(1, 2), Orientation.NORTH), output);
    }

}
