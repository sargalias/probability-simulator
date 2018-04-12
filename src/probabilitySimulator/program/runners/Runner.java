package probabilitySimulator.program.runners;

import java.util.Map;

public interface Runner {
    Map<Boolean, Integer> run();
    int runTimes();
}
