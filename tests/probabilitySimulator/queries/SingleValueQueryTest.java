package probabilitySimulator.queries;

import org.junit.jupiter.api.Test;
import probabilitySimulator.rollers.VariableDice;
import probabilitySimulator.rollers.Roller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class SingleValueQueryTest {

    @Test
    void constructorAcceptsPassvalueAndRoller() {
        Query svq = new SingleValueQuery(5, new VariableDice(6));
    }

    @Test
    void passValuesIsList() {
        SingleValueQuery svq = new SingleValueQuery(5, new VariableDice(6));
        assertTrue(svq.passValues() instanceof List);
    }

    @Test
    void passValuesIsSingleValueList() {
        SingleValueQuery svq = new SingleValueQuery(5, new VariableDice(6));
        assertEquals(1, svq.passValues().size());
    }

    @Test
    void passValuesSameAsConstructorParameter() {
        for (int i=0; i<1000; i++) {
            SingleValueQuery svq = new SingleValueQuery(i, new VariableDice(6));
            assertEquals(i, (int) svq.passValues().get(0));
        }
    }

    @Test
    void runAlwaysFalseWithNonCompatibleValuesAndRoller1() {
        Roller vd = new VariableDice(1);
        Query svq = new SingleValueQuery(10, vd);
        for (int i=0; i<1000000; i++) {
            assertFalse(svq.run());
        }
    }

    @Test
    void runAlwaysFalseWithNonCompatibleValuesAndRoller2() {
        Roller vd = new VariableDice(1);
        Query svq = new SingleValueQuery(-1, vd);
        for (int i=0; i<1000000; i++) {
            assertFalse(svq.run());
        }
    }

    @Test
    void runAlwaysTrueWithPassvalue0AndVariableDice1() {
        Roller vd = new VariableDice(1);
        Query svq = new SingleValueQuery(0, vd);
        for (int i=0; i<1000000; i++) {
            assertTrue(svq.run());
        }
    }

    @Test
    void run40to60PercentWith2SidedDiceAndPassvalue0() {
        Roller vd = new VariableDice(2);
        Query svq = new SingleValueQuery(0, vd);
        int maxI = 1000000;
        int wins = 0;
        for (int i=0; i<maxI; i++) {
            if (svq.run()) {
                wins++;
            }
        }
        assertEquals(maxI/2, wins, maxI/10);
    }

    @Test
    void runHalfChanceWith2SidedDiceAndPassvalue1() {
        Roller vd = new VariableDice(2);
        Query svq = new SingleValueQuery(1, vd);
        int maxI = 1000000;
        int wins = 0;
        for (int i=0; i<maxI; i++) {
            if (svq.run()) {
                wins++;
            }
        }
        assertEquals(maxI/2, wins, maxI/10);
    }

    @Test
    void runOneThirdChanceWith3SidedDiceAndPassvalue0() {
        Roller vd = new VariableDice(3);
        Query svq = new SingleValueQuery(0, vd);
        int maxI = 1000000;
        int wins = 0;
        for (int i=0; i<maxI; i++) {
            if (svq.run()) {
                wins++;
            }
        }
        assertEquals(maxI/3, wins, maxI/10);
    }

    @Test
    void runCorrectChanceWithXSidedDiceAndPassValue0() {
        int maxI = 1000000;
        for (int i=1; i<=1; i++) {
            int wins = 0;
            Roller vd = new VariableDice(i);
            Query svq = new SingleValueQuery(0, vd);
            for (int j=0; j<maxI; j++) {
                if (svq.run()) {
                    wins++;
                }
            }
            assertEquals(maxI/i, wins, maxI/10);
        }
    }

    @Test
    void getInfo() {
        for (int i=0; i<10; i++) {
            Roller vd = new VariableDice(10);
            Query svq = new SingleValueQuery(i, vd);
            assertEquals("Single Value Query: Passes with a single value of " + i, svq.getInfo());
        }
    }

    @Test
    void getAllInfo() {
        for (int i=0; i<10; i++) {
            Roller vd = new VariableDice(10);
            Query svq = new SingleValueQuery(i, vd);
            String passString = "Single Value Query: Passes with a single value of " + i + "\n" +
                    "Roller: " + vd.getInfo();
            assertEquals(passString, svq.getAllInfo());
        }
    }

}