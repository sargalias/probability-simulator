package probabilitySimulator.program.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;
import java.util.HashMap;

import probabilitySimulator.program.runners.Runner;
import probabilitySimulator.program.statistics.Statistics;
import probabilitySimulator.program.information.Information;

public class SimpleControllerTest {

    @Test
    void run_calls_runners_run_method() {
        Runner mockRunner = mock(Runner.class);
        Statistics mockStatistics = mock(Statistics.class);
        Information mockInformation = mock(Information.class);
        SimpleController sc = new SimpleController(mockRunner, mockStatistics, mockInformation);

        sc.run();
        verify(mockRunner).run();
    }

    @Test
    void correct_run_results_are_passed_to_statistics() {
        // Prepare results
        Map<Boolean, Integer> results = new HashMap<Boolean, Integer>();
        results.put(true, 600000);
        results.put(false, 400000);

        // Prepare controller components
        Runner mockRunner = mock(Runner.class);
        Statistics mockStatistics = mock(Statistics.class);
        Information mockInformation = mock(Information.class);

        // Prepare stub results for method .run.
        when(mockRunner.run()).thenReturn(results);

        // Initialise controller
        SimpleController sc = new SimpleController(mockRunner, mockStatistics, mockInformation);

        // Run, then call statistics
        sc.run();
        sc.statistics();

        verify(mockStatistics).statistics(results);
    }

    @Test
    void method_statistics_calls_method_statistics_of_statistics_module() {
        Runner mockRunner = mock(Runner.class);
        Statistics mockStatistics = mock(Statistics.class);
        Information mockInformation = mock(Information.class);
        SimpleController sc = new SimpleController(mockRunner, mockStatistics, mockInformation);

        sc.statistics();
        verify(mockStatistics).statistics(any());
    }

    @Test
    void method_statistics_returns_correct() {
        Runner mockRunner = mock(Runner.class);
        Statistics mockStatistics = mock(Statistics.class);
        Information mockInformation = mock(Information.class);

        when(mockStatistics.statistics(any())).thenReturn("Pass: 600000, Fail: 400000, Total: 1000000");
        SimpleController sc = new SimpleController(mockRunner, mockStatistics, mockInformation);

        assertEquals("Pass: 600000, Fail: 400000, Total: 1000000", sc.statistics());
    }

    @Test
    void method_information_calls_method_information_of_information_class() {
        Runner mockRunner = mock(Runner.class);
        Statistics mockStatistics = mock(Statistics.class);
        Information mockInformation = mock(Information.class);

        SimpleController sc = new SimpleController(mockRunner, mockStatistics, mockInformation);
        sc.information();
        verify(mockInformation).information();
    }

    @Test
    void method_information_returns_obtained_results() {
        Runner mockRunner = mock(Runner.class);
        Statistics mockStatistics = mock(Statistics.class);
        Information mockInformation = mock(Information.class);

        when(mockInformation.information()).thenReturn("Test string");

        SimpleController sc = new SimpleController(mockRunner, mockStatistics, mockInformation);
        assertEquals("Test string", sc.information());
    }
}