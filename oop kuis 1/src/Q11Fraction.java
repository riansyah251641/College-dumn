import java.util.Scanner;

public class Q11Fraction {
    /**
     * question description
     * - make int es ds to be fraction es/ds and int ep dp to be fraction ep/dp
     * - then count for the sum and the product of the two fractions
     * 
     * Solution
     * 1. make data type int es,ep,ds,dp to save two fraction.
     * 2. make char namely operator to save opesasi with two fraction, chose sum and
     * the product.
     * 3. Input data int & operator with scanner
     * 4. make if operator is + use formula to addiction two fraction, else use
     * formula to product two fraction
     * 5. dispay it main fuction
     * 
     */
    public static void main(String[] args) throws Exception {

        // save data input number
        int es, ep, ds, dp;
        // save data input addiction or product
        char operator;
        // input data from terminal
        Scanner inputdata = new Scanner(System.in);
        es = inputdata.nextInt();
        System.out.println("--");
        ds = inputdata.nextInt();
        System.out.print("Chose Operator (+ / *) ? ");
        operator = inputdata.next().charAt(0);
        ep = inputdata.nextInt();
        System.out.println("--");
        dp = inputdata.nextInt();
        int hasilAtas, hasilBawah;

        // fuction to determine to use addiction or product operasion in two fraction
        // save resurl fraction divide by two numerator as namely hasilAtas and
        // detemonator as namely hasilBawah
        if (operator == '+') {
            hasilAtas = es * dp + ep * ds;
            hasilBawah = ds * dp;
            System.out.println("\nOutput :\n" + hasilAtas + "\n--\n" + hasilBawah);
        } else if (operator == '*') {
            hasilAtas = es * ep;
            hasilBawah = ds * dp;
            System.out.println("\nOutput :\n" + hasilAtas + "\n--\n" + hasilBawah);
        }

    }
}
