package probabilitySimulator.runners;

import probabilitySimulator.rollers.*;
import probabilitySimulator.queries.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleQueryRunnerTest {
    private SingleQueryRunner single_value_query_variable_dice_setup_no_runTimes(int queryPassVal, int numSides) {
        Roller vd = new VariableDice(numSides);
        Query svq = new SingleValueQuery(queryPassVal, vd);
        return new SingleQueryRunner(svq);
    }

    private SingleQueryRunner single_value_query_variable_dice_setup(int runTimes, int queryPassVal, int numSides) {
        Roller vd = new VariableDice(numSides);
        Query svq = new SingleValueQuery(queryPassVal, vd);
        return new SingleQueryRunner(runTimes, svq);
    }

    @Test
    void run_returns_map_with_keys_pass_fail_total() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(-1, 6);
        Map<String, Integer> actual = sqr.run();
        assertTrue(actual.containsKey("pass"));
        assertTrue(actual.containsKey("fail"));
        assertTrue(actual.containsKey("total"));
        assertTrue(actual.size() == 3);
    }

    @Test
    void fail_total_1000000_pass_0_with_query_negative_1_variable_dice_roller() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(-1, 6);
        Map<String, Integer> actual = sqr.run();
        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("pass", 0);
        expected.put("fail", 1000000);
        expected.put("total", 1000000);
        assertEquals(expected, actual);
    }

    @Test
    void pass_total_1000000_fail_0_with_query_0_variable_dice_roller_1() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(0, 1);
        Map<String, Integer> actual = sqr.run();
        Map<String, Integer> expected = new HashMap<String, Integer>();
        expected.put("pass", 1000000);
        expected.put("fail", 0);
        expected.put("total", 1000000);
        assertEquals(expected, actual);
    }


    // RUNTIMES TESTS ---------------------
    @Test
    void constructor_negative_runTimes_throws_IllegalArgument_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {single_value_query_variable_dice_setup(-1, 1, 1);});
    }

    @Test
    void constructor_0_runTimes_throws_IllegalArgument_Exception() {
        assertThrows(IllegalArgumentException.class, () -> {single_value_query_variable_dice_setup(0, 1, 1);});
    }

    @Test
    void runTimes_returns_1000000_by_default_constructor() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(1, 6);
        assertEquals(1000000, sqr.runTimes());
    }

    @Test
    void runTimes_returns_1000000_with_constructor_1000000() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup(1000000, 1, 6);
        assertEquals(1000000, sqr.runTimes());
    }

    @Test
    void runTimes_returns_1_with_constructor_1() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup(1000000, 1, 6);
        assertEquals(1000000, sqr.runTimes());
    }
}