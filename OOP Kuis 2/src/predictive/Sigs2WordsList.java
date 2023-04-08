package predictive;

public class Sigs2WordsList {
	public static void main(String[] args) {
		DictionaryListImpl dictionary = new DictionaryListImpl();
		long run = System.nanoTime();
		for (String argument : args) {
			System.out.println(argument + " : " + dictionary.signatureToWords(argument));
		}
		long stop = System.nanoTime();
		long timeprogram = stop - run;
		System.out.println("Execution time with Sigs2WordsList : " + timeprogram + " nanoseconds");
	}

}
