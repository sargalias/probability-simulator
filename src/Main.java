import probabilitySimulator.utility.DiceRoller;
import probabilitySimulator.rollers.VariableDice;


public class Main {
    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(DiceRoller.roll(6));
        }
        VariableDice vd6 = new VariableDice(6);
        for (int i=0; i<10; i++) {
            System.out.println(vd6.roll());
        }
    }

}
