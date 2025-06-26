package mowitnow;

import mowitnow.io.parser.LawnParser;
import mowitnow.mower.Lawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LawnParserTest {

    @Test
    public void parse() {
        LawnParser lawnParser = new LawnParser();
        Lawn output = lawnParser.parse("10 5");

        assertEquals(new Lawn(10, 5), output);
    }

}
