package predictive;

/**
 * sigsWordsMap is class for testing the wordToSignature from DictionaryMapImpl
 * class
 */
public class Sigs2WordsMap {
	public static void main(String[] args) {
		Dictionary dictionary = new DictionaryMapImpl();
		long run = System.nanoTime();
		for (String argument : args) {
			System.out.println(argument + " : " + dictionary.signatureToWords(argument));
		}
		long stop = System.nanoTime();
		long timeprogram = stop - run;
		System.out.println("Execution time with sigs2WordsMap : " + timeprogram + " nanoseconds");
	}
}
