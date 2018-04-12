package probabilitySimulator.runners;

import probabilitySimulator.queries.*;
import java.util.Map;
import java.util.HashMap;

public class SingleQueryRunner {
    private int runTimes;

    public SingleQueryRunner(int runTimes, Query query) throws IllegalArgumentException {
        if (runTimes < 1) {
            throw new IllegalArgumentException("runTimes must be 1 or more");
        }
        this.runTimes = runTimes;
    }

    public SingleQueryRunner(Query query) {
        this(1000000, query);
    }

    public Map<String, Integer> run() {
        Map<String, Integer> results = new HashMap<String, Integer>();
        results.put("pass", 0);
        results.put("fail", 0);
        results.put("total", 0);
        return results;
    }

    public int runTimes() {
        return runTimes;
    }
}
