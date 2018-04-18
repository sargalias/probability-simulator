package probabilitySimulator.program.controllers;

import java.util.Map;

import probabilitySimulator.program.runners.Runner;
import probabilitySimulator.program.statistics.Statistics;
import probabilitySimulator.program.information.Information;

public class SimpleController {
    private Runner runner;
    private Map<Boolean, Integer> results;
    private Statistics statistics;
    private Information information;

    public SimpleController(Runner runner, Statistics statistics, Information information) {
        this.runner = runner;
        this.statistics = statistics;
        this.information = information;
    }

    public void run() {
        this.results = this.runner.run();
    }

    public String statistics() {
        return this.statistics.statistics(results);
    }

    public String information() {
        return this.information.information();
    }
}
