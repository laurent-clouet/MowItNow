package mowitnow.coordinate;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * Orientation is based on a vector of a grid
 */
@Getter
@RequiredArgsConstructor
public enum Orientation {
    NORTH("N", 0, 1),
    EAST("E", 1, 0),
    WEST("W", -1, 0),
    SOUTH("S", 0, -1);

    final String code;

    final int x;

    final int y;

    public Orientation right() {
        return byVector(y, -x);
    }

    public Orientation left() {
        return byVector(-y, x);
    }

    public static Orientation byVector(final int a, final int b) {
        return Arrays.stream(values())
                .filter(orientation -> orientation.x == a && orientation.y == b)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Orientation not found"));
    }
    
    public static Orientation byCode(@NonNull final String code) {
        return Arrays.stream(values())
                .filter(orientation -> orientation.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Orientation not found"));
    }
}
