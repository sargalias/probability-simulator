package probabilitySimulator.utility;

import java.util.Random;

public class ChanceRoller {
    private static final Random random = new Random();

    public static boolean rollBoolean(double chance) throws IllegalArgumentException {
        if (chance < 0) {
            throw new IllegalArgumentException("Chance cannot be less than 0");
        } else if (chance > 1) {
            throw new IllegalArgumentException("Chance cannot be more than 1");
        }
        return random.nextDouble() < chance;
    }
}
