package probabilitySimulator.rollers;

import probabilitySimulator.utility.DiceRoller;

import java.util.List;
import java.util.ArrayList;

public class VariableDice implements Roller {
    private int numValues;

    public VariableDice(int numValues) throws IllegalArgumentException {
        if (numValues <= 0) {
            throw new IllegalArgumentException("numValues must be 1 or more");
        }
        this.numValues = numValues;
    }

    public int roll() {
        return DiceRoller.roll(numValues);
    }

    public List<Integer> possibleValues() {
        List<Integer> possibleValues = new ArrayList<Integer>();
        for (int i=1; i<=numValues; i++) {
            possibleValues.add(i);
        }
        return possibleValues;
    }
}
