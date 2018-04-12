package probabilitySimulator.utility;

import java.util.Random;

public class DiceRoller {
    private static final Random random = new Random();

    public static int roll(int numValues) throws IllegalArgumentException {
        if (numValues <= 0) {
            throw new IllegalArgumentException("number of possible Values must be one or more");
        }
        return random.nextInt(numValues);
    }
}
