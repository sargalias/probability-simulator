package probabilitySimulator.rollers;

import java.util.List;

public interface Roller {
    int roll();
    List<Integer> possibleValues();
}
