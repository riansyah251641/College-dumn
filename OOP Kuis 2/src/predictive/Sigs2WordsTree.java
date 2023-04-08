package predictive;

public class Sigs2WordsTree {

	public static void main(String[] args) {
		Dictionary dictionary = new DictionaryTreeImpl("assets/words");
		long run = System.nanoTime();
		for (String argument : args) {
			System.out.println(argument + " : " + dictionary.signatureToWords(argument));
		}
		long stop = System.nanoTime();
		long timeprogram = stop - run;
		System.out.println("Execution time: " + timeprogram + " nanoseconds");
	}
}
