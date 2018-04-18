package probabilitySimulator.program.statistics;

import java.util.Map;
import java.util.HashMap;

public class SimpleStatistics implements Statistics {

    private void checkResultFormat(Map<Boolean, Integer> results) throws IllegalArgumentException{
        if (results == null || results.get(true) == null || results.get(false) == null) {
            throw new IllegalArgumentException("Results cannot be null.");
        }
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

    private String buildString(int pass, int fail, int total, String chanceStr) {
        return "Pass: " + pass + "\n" +
                "Fail: " + fail + "\n" +
                "Total rolls: " + total + "\n"+
                "Success chance: " + chanceStr + "%";
    }

    @Override
    public String statistics(Map<Boolean, Integer> results) throws IllegalArgumentException {
        try {
            checkResultFormat(results);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        int pass = results.get(true);
        int fail = results.get(false);
        int total = pass + fail;
        String chanceStr = chanceString(results);
        return buildString(pass, fail, total, chanceStr);
    }
}
