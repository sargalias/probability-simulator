package probabilitySimulator.utility;

import org.junit.jupiter.api.Test;
import probabilitySimulator.utility.DiceRoller;

import static org.junit.jupiter.api.Assertions.*;

class DiceRollerTest {

    @Test
    void rollOnly0to5with6values() {
        int maxI = 1000000;
        for (int i=0; i<maxI; i++) {
            int roll = DiceRoller.roll(6);
            assertTrue(roll >= 0 && roll <=5, "6 sided die should roll 0 to 5 but rolled: " + roll);
        }
    }

    @Test
    void rollDistributionWithin20Percent6numValues() {
        int[] rolls = new int[6];
        int maxI = 1000000;
        for (int i=0; i<maxI; i++) {
            int roll = DiceRoller.roll(6);
            rolls[roll]++;
        }
        int perfectDistributedRolls = maxI / 6;
//         we want to apply +- 20% to that.
        int maxRoll = (int) (perfectDistributedRolls + 0.2 * maxI);
        int minRoll = (int) (perfectDistributedRolls - 0.2 * maxI);
        if (minRoll < 0) {
            minRoll = 0;
        }
        for (int roll : rolls) {
            assertTrue(minRoll <= roll && roll <= maxRoll, "Roll distribution not even. Rolls were: " + roll + ", should be between " + minRoll + " and " + maxRoll);
        }
    }


    @Test
    void rollDistributionWithin20Percent3numValues() {
        int[] rolls = new int[6];
        int maxI = 1000000;
        for (int i=0; i<maxI; i++) {
            int roll = DiceRoller.roll(3);
            rolls[roll]++;
        }
        int perfectDistributedRolls = maxI / 3;
//         we want to apply +- 20% to that.
        int maxRoll = (int) (perfectDistributedRolls + 0.2 * maxI);
        int minRoll = (int) (perfectDistributedRolls - 0.2 * maxI);
        if (minRoll < 0) {
            minRoll = 0;
        }
        for (int i=0; i<3; i++) {
            assertTrue(minRoll <= rolls[i] && rolls[i] <= maxRoll, "Roll distribution not even. Rolls were: " + rolls[i] + ", should be between " + minRoll + " and " + maxRoll);
        }
    }

    @Test
    void throwsIllegalArgumentExceptionWith0NumValues() {
        assertThrows(IllegalArgumentException.class,
                ()->{DiceRoller.roll(0);});
    }
}