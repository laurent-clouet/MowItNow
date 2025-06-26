package mowitnow.main;

import mowitnow.io.SystemLoader;
import mowitnow.mower.Mower;
import mowitnow.mower.Runner;

import java.io.File;

public class Main {
    public static void main(String... args) {
        if (args.length == 1) {
            File file = new File(args[0]);

            Runner runner = new SystemLoader().fromFile(file);

            runner.run();

            for (Mower mower : runner.getMowers()) {
                System.out.printf("%d %d %s\n", mower.getPosition().getX(), mower.getPosition().getY(), mower.getOrientation().getCode());
            }

        } else {
            throw new IllegalArgumentException();
        }
    }
}
