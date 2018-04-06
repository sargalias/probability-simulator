package probabilitySimulator.rollers;

import probabilitySimulator.utility.DiceRoller;

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

    public int numValues() {
        return numValues;
    }
}
