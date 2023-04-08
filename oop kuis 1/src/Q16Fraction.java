public class Q16Fraction {
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

    // // Deklarasi Variable for data of fraction
    int numerator, denominator;

    // take input from main fuction in Q16FractionTest.java file to numerator and
    // denominator
    public Q16Fraction(int a, int b) {
        this.numerator = a;
        this.denominator = b;
    }

    // fuction return string to display fraction
    public String toString() {
        return numerator + "/" + denominator;
    }

    // function to return result of multipy two fraction
    // take construktor namely data to get other fraction
    // then save it in pembilang & penyebut as a result numerator & denumerator from
    // multipy two fraction with formula same with exam no 1 to multipy
    // then return the result to string type
    public String getProduct(Q16Fraction data) {
        int pembilang = numerator * data.numerator;
        int penyebut = denominator * data.denominator;
        return pembilang + "/" + penyebut;
    }

    // function to return result of addtion two fraction
    // take construktor namely data to get other fraction
    // then save it in pembilang & penyebut as a result numerator & denumerator from
    // multipy two fraction with formula same with exam no 1 to addtion
    // then return the result to string type
    public String getSum(Q16Fraction data) {
        int pembilang = numerator * data.denominator + denominator * data.numerator;
        int penyebut = denominator * data.denominator;
        return pembilang + "/" + penyebut;
    }
}
