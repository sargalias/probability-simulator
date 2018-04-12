package probabilitySimulator.rollers;

import probabilitySimulator.utility.DiceRoller;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class VariableDice implements Roller {
    private int numSides;
    private static Random random = new Random();

    public VariableDice(int numSides) throws IllegalArgumentException {
        if (numSides <= 0) {
            throw new IllegalArgumentException("numSides must be 1 or more");
        }
        this.numSides = numSides;
    }

    public int roll() {
        return random.nextInt(numSides);
    }

    public List<Integer> possibleValues() {
        List<Integer> possibleValues = new ArrayList<Integer>();
        for (int i=1; i<=numSides; i++) {
            possibleValues.add(i);
        }
        return possibleValues;
    }
}
