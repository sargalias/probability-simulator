import probabilitySimulator.program.controllers.*;
import probabilitySimulator.program.information.*;
import probabilitySimulator.program.runners.*;
import probabilitySimulator.program.statistics.*;
import probabilitySimulator.rollers.*;
import probabilitySimulator.queries.*;
import probabilitySimulator.program.runners.*;

public class Main {
    public static void main(String[] args) {
        Roller vd = new VariableDice(6);
        Query svq = new SingleValueQuery(1, vd);
        Runner sqr = new SingleQueryRunner(1000000, svq);
        Statistics s = new SimpleStatistics();
        Information i = new SimpleInformation(svq);
        SimpleController sc = new SimpleController(sqr, s, i);
        sc.run();
        System.out.println("Statistics:");
        System.out.println(sc.statistics());
        System.out.println();
        System.out.println("Information:");
        System.out.println(sc.information());
    }
}
