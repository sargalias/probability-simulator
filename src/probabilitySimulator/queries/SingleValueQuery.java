package probabilitySimulator.queries;

import probabilitySimulator.rollers.Roller;

import java.util.List;
import java.util.ArrayList;

public class SingleValueQuery implements Query {
    private int passValue;
    private Roller roller;

    public SingleValueQuery(int passValue, Roller roller) {
        this.passValue = passValue;
        this.roller = roller;
    }

    @Override
    public boolean run() {
        return passValue == roller.roll();
    }

    @Override
    public String getInfo() {
        return "Single Value Query: Passes with a single value of " + this.passValue;
    }

    @Override
    public String getAllInfo() {
        return "Single Value Query: Passes with a single value of " + this.passValue + "\n" +
                "Roller: " + this.roller.getInfo();
    }

    public List<Integer> passValues() {
        List<Integer> passValues = new ArrayList<Integer>();
        passValues.add(this.passValue);
        return passValues;
    }
}
