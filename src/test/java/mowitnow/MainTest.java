package mowitnow;

import lombok.SneakyThrows;

import mowitnow.coordinate.Orientation;
import mowitnow.coordinate.Position;
import mowitnow.io.SystemLoader;
import mowitnow.mower.Lawn;
import mowitnow.mower.Runner;

import mowitnow.mower.Mower;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    final String RESSOURCES_FILES = "./src/test/resources/";

    @Test
    @SneakyThrows
    public void loaderTest() {
        File file = new File(RESSOURCES_FILES + "test_main_ok.txt");
        Runner runner = new SystemLoader().fromFile(file);

        // check lawn size
        Lawn p = new Lawn(5, 5);
        assertEquals(p, runner.getLawn());

        runner.run();

        assertEquals(2, runner.getMowers().size());

        // first mower should be: "1 3 N"
        Mower firstMower = runner.getMowers().get(0);
        assertEquals(Position.at(1, 3), firstMower.getPosition());
        assertEquals(Orientation.NORTH, firstMower.getOrientation());

        // second mower should be: "5 1 E"
        Mower secondMower = runner.getMowers().get(1);
        assertEquals(Position.at(5, 1), secondMower.getPosition());
        assertEquals(Orientation.EAST, secondMower.getOrientation());
    }
}