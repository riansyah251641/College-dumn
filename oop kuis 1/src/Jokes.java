public class Jokes {
    /**
     * 
     * question description
     * create a sentence that is stored in the string joke_string
     * determine whether the sentence is less than 20 letters or not
     * if less 20 then output it's funny
     * else output it is not funny
     * then create a function first_word() to display the first word sentence in
     * joke_string
     * 
     * Solution
     * 1. in class jokes make type String name joke_string to save input sentence.
     * 2. then create fuction void namely is_funny to determine whether the sentence
     * is less than 20 letters or not and the result
     * 3. make fuction void namely first_word to get the first word in string
     * joke_string
     * 4. Display the resuly in main function
     * 
     */

    // // Deklarasi Variable for String of the joke
    private static String joke_string;

    // Function to determine if a joke is funny or not
    // If the length of the joke is < 20, it's funny. Otherwise, it is not funny
    public static void is_funny() {
        if (joke_string.length() < 20) {
            System.out.println("it's funny");
        } else {
            System.out.println("it is not funny");
        }
    }

    // Function to get the first word of the joke, separated by space
    // as long as it take first word by splits the string by a blank space " "
    // then save it into new string namely kataPertama.
    public static void first_word() {
        String[] kataPertama = joke_string.split(" ");
        System.out.println(kataPertama[0]);
    }

    // Display in function main
    public static void main(String[] args) {
        joke_string = "Knock knock who's there?";
        is_funny();
        first_word();
        joke_string = "Your life";
        is_funny();
        first_word();
    }
}
