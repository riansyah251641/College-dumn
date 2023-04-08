public class Q15Weight {

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
    // Deklarasi Variable
    double weight;

    // Make Konstruktor with Parameter
    public Q15Weight(Double berat) {
        this.weight = berat;
    }

    // fuction getter to change kolograms to pouns
    public double getPouns() {
        return weight / 0.45359237;
    }

    // fuction getter to change pouns to kilograms
    public double getKilograms() {
        return weight * 0.45359237;
    }
}
