package probabilitySimulator.rollers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VariableDiceTest {

    @Test
    void throwsIllegalArgumentExceptionWith0NumValues() {
        assertThrows(IllegalArgumentException.class,
                ()->{new VariableDice(0);});
    }

    @Test
    public void correctNumValues1to100() {
        for (int i=1; i<=100; i++) {
            VariableDice dice = new VariableDice(i);
            assertEquals(i, dice.numValues(), "Dice should have " + i + " sides but has " + dice.numValues() + " sides.");
        }
    }

    @Test
    void correctRangeOfRolls() {
        int maxI = 1000000;
        for (int i=1; i<15; i++) {
            Roller dice = new VariableDice(i);
            for (int j=0; j<maxI; j++) {
                int roll = dice.roll();
                assertTrue(roll >= 0 && roll <i, i + " sided dice rolled " + roll);
            }
        }
    }

    @Test
    void fullRangeOfRollsNumValues1To15() {
        int maxI = 1000000;
        for (int i=1; i<=15; i++) {
            Roller dice = new VariableDice(i);
            int[] rolls = new int[i];
            for (int j=0; j<maxI; j++) {
                int roll = dice.roll();
                rolls[roll]++;
            }
            for (int k=0; k<i; k++) {
                assertTrue(rolls[k] > 0,
                        i + " sided dice. Rolls for " + k + " were " + rolls[k]);
            }
        }
    }

    @Test
    void rollDistributionWithin10PercentNumvalues1To10() {
        int maxI = 1000000;
        for (int i=1; i<=10; i++) {
            int[] rolls = new int[i];
            VariableDice dice = new VariableDice(i);
            for (int j=0; j<maxI; j++) {
                int roll = dice.roll();
                rolls[roll]++;
            }
            for (int k=0; k<i; k++) {
                assertEquals(maxI/i, rolls[k], maxI * 0.1);
            }
        }
    }
}