package probabilitySimulator.program.runners;

import probabilitySimulator.queries.*;
import java.util.Map;
import java.util.HashMap;

public class SingleQueryRunner implements Runner {
    private int runTimes;
    private Query query;

    public SingleQueryRunner(int runTimes, Query query) throws IllegalArgumentException {
        if (runTimes < 1) {
            throw new IllegalArgumentException("runTimes must be 1 or more");
        }
        this.runTimes = runTimes;
        this.query = query;
    }

    public SingleQueryRunner(Query query) {
        this(1000000, query);
    }

    @Override
    public Map<Boolean, Integer> run() {
        int pass = 0;
        int fail = 0;
        for (int i=0; i<runTimes; i++) {
            if (query.run()) {
                pass++;
            } else {
                fail++;
            }
        }
        Map<Boolean, Integer> results = new HashMap<Boolean, Integer>();
        results.put(true, pass);
        results.put(false, fail);
        return results;
    }

    @Override
    public int runTimes() {
        return runTimes;
    }
}
