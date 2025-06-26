package mowitnow.io.parser;


import mowitnow.mower.Lawn;

/**
 * Parse a string to get a Lawn object
 */
public class LawnParser implements Parser<String, Lawn> {

    private static final String SEPARATOR = " ";
    private static final String PATTERN = "^\\d+ \\d+$";

    @Override
    public Lawn parse(String source) {
        if (!source.matches(PATTERN)) {
            throw new IllegalArgumentException("Missing information for parsing lawn");
        }

        String[] champs = source.split(SEPARATOR);
        return new Lawn(Integer.parseInt(champs[0]), Integer.parseInt(champs[1]));
    }

}
