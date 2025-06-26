package mowitnow.io.parser;

/**
 * Generic class to parse an Input to an Outpyt
 *
 * @param <I> Input
 * @param <O> Output
 */
public interface Parser<I, O> {

    O parse(final I source);
}
