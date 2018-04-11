package probabilitySimulator.queries;

import java.util.List;

public interface Query {
    boolean run();
    List<Integer> passValues();
}
