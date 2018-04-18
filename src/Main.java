import probabilitySimulator.rollers.*;
import probabilitySimulator.queries.*;
import probabilitySimulator.program.runners.*;

public class Main {
    public static void main(String[] args) {
        Roller vd = new VariableDice(2);
        Query svq = new SingleValueQuery(1, vd);
        Runner sqr = new SingleQueryRunner(1000000, svq);
        System.out.println(sqr.run());
    }
}
