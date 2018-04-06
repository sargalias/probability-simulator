package probabilitySimulator.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceRollerTest {

    @Test
    void roll_always_false_when_chance_is_0() {
        for (int i=0; i<1000; i++) {
            boolean res = ChanceRoller.rollBoolean(0);
            assertFalse(res);
        }
    }

    @Test
    void roll_always_true_when_chance_is_1() {
        for (int i=0; i<1000; i++) {
            boolean res = ChanceRoller.rollBoolean(1);
            assertTrue(res);
        }
    }

    @Test
    void roll_half_chance_within_10_percent_accuracy() {
        int t = 0;
        for (int i=0; i<1000; i++) {
            boolean res = ChanceRoller.rollBoolean(0.5);
            if (res) {
                t++;
            }
        }
        double percent = t * 100 / 1000;
        assertTrue(percent < 60,
                "Percent was: " + percent + ". Expected under 60");
        assertTrue(percent > 40,
                "Percent was: " + percent + ". Expected over 40");
    }

    @Test
    void roll_10_chance_within_10_percent_accuracy() {
        int t = 0;
        for (int i=0; i<1000; i++) {
            boolean res = ChanceRoller.rollBoolean(0.1);
            if (res) {
                t++;
            }
        }
        double percent = t * 100 / 1000;
        assertTrue(percent < 20,
                "Percent was: " + percent + ". Expected under 20");
        assertTrue(percent > 0,
                "Percent was: " + percent + ". Expected over 0");
    }

    @Test
    void roll_90_chance_within_10_percent_accuracy() {
        int t = 0;
        for (int i=0; i<1000; i++) {
            boolean res = ChanceRoller.rollBoolean(0.9);
            if (res) {
                t++;
            }
        }
        double percent = t * 100 / 1000;
        assertTrue(percent < 100,
                "Percent was: " + percent + ". Expected under 100");
        assertTrue(percent > 80,
                "Percent was: " + percent + ". Expected over 80");
    }

    @Test
    void roll_negative_chance_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                ()->{ChanceRoller.rollBoolean(-5);});
    }

    @Test
    void roll_greater_than_1_chance_throws_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                ()->{ChanceRoller.rollBoolean(2);});
    }

}