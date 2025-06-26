package mowitnow.mower;

import lombok.EqualsAndHashCode;
import mowitnow.coordinate.Orientation;
import mowitnow.coordinate.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Queue;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class Mower {
    private Position position;

    private Orientation orientation;

    @NonNull
    private Queue<Instruction> instructions;

    public Mower(final Position position, final Orientation orientation) {
        super();
        this.position = position;
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Mower (position=" + position + ", orientation=" + orientation + ")";
    }
}
