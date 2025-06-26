package mowitnow.mower;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Instruction from the system
 */
@Getter
@AllArgsConstructor
public enum Instruction {
    ROTATE_RIGHT('D'),
    ROTATE_LEFT('G'),
    FORWARD('A');

    private char code;

}