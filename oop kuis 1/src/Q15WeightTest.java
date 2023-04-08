import java.util.Scanner;

public class Q15WeightTest {
    /**
     * Decripsion Question
     * - wrote a program that convertsmasses given in the imperial system into the
     * metric system.
     * - pounts to kilograms or kilograms to pounts with construktor
     * - 1 pound = 0.45359237 kilograms
     * 
     * Solution
     * 1. declare variable to save input weight
     * 2. make konstruktor to input weight
     * 3. Make fuction getter to change pounds to kilograms and kilograms to pounds
     * 4. Display it in fuction main at Q15WeightTest.java
     * 
     */
    public static void main(String[] args) throws Exception {
        double number;
        // input data number
        Scanner input = new Scanner(System.in);
        System.out.print("Input Number : ");
        number = input.nextDouble();
        Q15Weight convert = new Q15Weight(number);
        System.out.println("\nOutput");
        System.out.println("-------------------");

        // output from input be pouns covert be kilograms
        System.out.println("1. imperial system (Pouns) into the metric system( Kilograms).");
        System.out.println("\t" + convert.weight + " (Pouns) equal to " + convert.getKilograms() + " (Kilograms)\n");

        // output from input be pouns Kiligrams be Pouns
        System.out.println("2. metric system(Kilograms) into the imperial system (Pouns)");
        System.out.println("\t" + convert.weight + " (kilograms) equal to " + convert.getPouns() + " (Pouns)\n");

    }
}
