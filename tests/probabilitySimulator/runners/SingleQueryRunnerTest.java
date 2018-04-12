package probabilitySimulator.runners;

import probabilitySimulator.rollers.*;
import probabilitySimulator.queries.*;
import java.util.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleQueryRunnerTest {

    // Helper functions start ---------------------
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
    // Helper functions end ---------------------


    // run tests start -----------------
    @Test
    void run_returns_map_with_keys_pass_fail_total() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(-1, 6);
        Map<String, Integer> actual = sqr.run();
        assertTrue(actual.containsKey("pass"));
        assertTrue(actual.containsKey("fail"));
        assertTrue(actual.containsKey("total"));
        assertTrue(actual.size() == 3);
    }

    private void pass_fail_correct_proportions_(SingleQueryRunner sqr, int pass, int total, int delta) {
        Map<String, Integer> actual = sqr.run();
        Map<String, Integer> expected = new HashMap<String, Integer>();
        assertEquals(pass, (int) actual.get("pass"), delta);
        assertEquals(total-pass, (int) actual.get("fail"), delta);
        assertEquals(total, (int) actual.get("total"));
    }

    @Test
    void fail_total_1000000_pass_0_with_query_negative_1_variable_dice_roller() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(-1, 6);
        pass_fail_correct_proportions_(sqr, 0, 1000000, 0);
    }

    @Test
    void pass_total_1000000_fail_0_with_query_0_variable_dice_roller_1() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(0, 1);
        pass_fail_correct_proportions_(sqr, 1000000, 1000000, 0);
    }

    @Test
    void pass_roughly_half_with_corresponding_query_and_rollers() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(1, 2);
        pass_fail_correct_proportions_(sqr, 500000, 1000000, 100000);
    }

    @Test
    void pass_roughly_third_with_corresponding_query_and_rollers() {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup_no_runTimes(2, 3);
        pass_fail_correct_proportions_(sqr, 333333, 1000000, 100000);
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

    private void run_totals_correspond_with_constructor_runTimes(int runTimes) {
        SingleQueryRunner sqr = single_value_query_variable_dice_setup(runTimes, 0, 1);
        Map<String, Integer> actual = sqr.run();
        assertEquals(runTimes, (int) actual.get("total"));
    }

    @Test
    void run_total_1_with_constructor_1() {
        run_totals_correspond_with_constructor_runTimes(1);
    }

    @Test
    void run_total_2_with_constructor_2() {
        run_totals_correspond_with_constructor_runTimes(2);
    }

    @Test
    void run_total_1500_with_constructor_1500() {
        run_totals_correspond_with_constructor_runTimes(1500);
    }
}