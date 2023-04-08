import java.util.Scanner; // take function scanner to our class

public class Q12Time {
    /**
     * question description
     * - determine the angle formed by the hour arrow and minute arrow on the wall
     * clock.
     * - with an angle starting from the minute arrow and pointing to the right
     * - Display the result of angel to terminal
     * 
     * Solution
     * 1. save input hours and minutes , in data type Int
     * 2. for hours if more than 12 , do modulus 12
     * 3. for hours product with 30 to change in degree
     * 4. for minutes product with 6 to change in degree
     * 5. take the difference between the angles of the two arrows
     * 
     */
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in); // define function scanner with input name
        int hours, minutes; // add data type int to take input
        System.out.print("Input Hours : ");
        hours = input.nextInt(); // take input hours from user
        System.out.print("Input Minutes : ");
        minutes = input.nextInt(); // take input minutes from user

        // condicion if hours number more than 12, so hours back to zero use with module
        if (hours >= 12) {
            hours %= 12;
        }
        // change all input hours and minutes to degree
        int degreeHours, degreeMinutes, ResultAngel;
        degreeHours = hours * 30;
        degreeMinutes = minutes * 6;

        // divide condition of result angel between hours and minutes cause take angel
        // from minutes to hours which is clockwise.
        if (degreeHours >= degreeMinutes) {
            ResultAngel = degreeHours - degreeMinutes;
        } else {
            ResultAngel = 360 - (degreeMinutes - degreeHours);

        }
        // output resultAngel who get from function in our condition if else in top
        System.out.println("Output : " + ResultAngel);
    }
}
