package probabilitySimulator.program.statistics;

import java.util.Map;
import java.util.HashMap;

public class SimpleStatistics implements Statistics {

    private Map<Boolean, Integer> normalizeNullResults(Map<Boolean, Integer> results) {
        if (results == null) {
            results = new HashMap<Boolean, Integer>();
            results.put(true, 0);
            results.put(false, 0);
        }
        return results;
    }

    private String chanceString(Map<Boolean, Integer> results) {
        int total = results.get(true) + results.get(false);
        double chance;
        if (total == 0) {
            chance = 0.00;
        } else {
            chance = (double) 100 * 100 * results.get(true) / total / 100;
        }
        String chanceStr = String.format("%.2f", chance);
        return chanceStr;
    }

    @Override
    public String statistics(Map<Boolean, Integer> results) {
        results = normalizeNullResults(results);
        int total = results.get(true) + results.get(false);
        String chanceStr = chanceString(results);
        String result = "" +
                "Pass: " + results.get(true) + "\n" +
                "Fail: " + results.get(false) + "\n" +
                "Total rolls: " + total + "\n"+
                "Success chance: " + chanceStr + "%";
        return result;
    }
}
