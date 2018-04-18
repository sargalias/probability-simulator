package probabilitySimulator.program.statistics;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.HashMap;

class SimpleStatisticsTest {

    public String correctString(String i1, String i2, String i3, String i4) {
        return "Pass: " + i1 + "\n" +
                "Fail: " + i2 + "\n" +
                "Total rolls: " + i3 + "\n" +
                "Success chance: " + i4 + "%";
    }

    @Test
    void statistics_called_with_null_throws_illegal_argument_exception() {
        SimpleStatistics ss = new SimpleStatistics();
        assertThrows(IllegalArgumentException.class, () -> {ss.statistics(null);});
    }

    @Test
    void statistics_called_with_true_or_false_null_throws_illegal_argument_exception() {
        SimpleStatistics ss = new SimpleStatistics();
        Map<Boolean, Integer> results = new HashMap<Boolean, Integer>();
        results.put(true, null);
        results.put(false, 0);
        assertThrows(IllegalArgumentException.class, () -> {ss.statistics(results);});

        results.put(true, 0);
        results.put(false, null);
        assertThrows(IllegalArgumentException.class, () -> {ss.statistics(results);});
    }

    @Test
    void statistics_0_correct_return() {
        SimpleStatistics ss = new SimpleStatistics();
        Map<Boolean, Integer> results = new HashMap<Boolean, Integer>();
        results.put(true, 0);
        results.put(false, 0);
        assertEquals(correctString("0", "0", "0", "0.00"), ss.statistics(results));
    }

    @Test
    void statistics_correct_with_average_values() {
        SimpleStatistics ss = new SimpleStatistics();
        Map<Boolean, Integer> results = new HashMap<Boolean, Integer>();
        results.put(true, 555500);
        results.put(false, 444500);
        assertEquals(correctString("555500", "444500", "1000000", "55.55"), ss.statistics(results));
    }
}