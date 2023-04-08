import java.util.Scanner;

public class Q16FractionTest {
    /**
     * question description
     * create two construktor who save data nomerator and denumerator in each
     * construktor
     * make function namely toString for get the output numerator/denumerator in a
     * construktor
     * make fuction namely GetProduct to get the answer if we multiply data
     * fractions from two construktor.
     * Make function namely getSum to get the answer if we addition data fraction
     * frow two construktor
     * display the answer in main fuction at file Q16FeactionTest.java
     * 
     * Solution
     * 1. make new file namely Q16Fraction.java to save our construktor and other
     * function
     * 2. in Q16Fraction.java file make int numerator and denumerator to save a
     * input.
     * 3. make a public function to set the input into numerator and denumemrator
     * 4. make a fuction string type namely ToString to return fraction output in
     * construktor user chose
     * 5. make a fuction string type namely GetProduct to return result of multipy
     * fraction
     * 6. make a fuction string type namely GetSum to return result of addtion
     * fraction
     */
    public static void main(String[] args) throws Exception {

        // test input in costruktor namely f1 with 1 as a numerator and 2 as a
        // denumerator
        Q16Fraction f1 = new Q16Fraction(1, 2);
        // test input in costruktor namely f2 with 3 as a numerator and 3 as a
        // denumerator
        Q16Fraction f2 = new Q16Fraction(3, 7);
        System.out.println("\nOutput\n");
        System.out.println("1 to String \t:" + f1.toString());
        System.out.println("GetProduct \t:" + f2.getProduct(f1));
        System.out.println("GetSum \t\t:" + f2.getSum(f1));
    }
}
