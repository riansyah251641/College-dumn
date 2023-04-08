package predictive;

public class DictionaryListImplTest {
	public static void main(String[] args) {
		DictionaryListImpl dictionary = new DictionaryListImpl();
		long run = System.nanoTime();
		System.out.println(dictionary.signatureToWords("4663"));
		System.out.println(dictionary.signatureToWords("43556"));
		System.out.println(dictionary.signatureToWords("96753"));
		System.out.println(dictionary.signatureToWords("69"));
		System.out.println(dictionary.signatureToWords("6263"));
		System.out.println(dictionary.signatureToWords("47"));
		System.out.println(dictionary.wordToSignature("hello"));
		System.out.println(dictionary.wordToSignature("world"));
		long stop = System.nanoTime();
		long timeprogram = stop - run;
		System.out.println("Execution time : " + timeprogram + " nanoseconds");
	}
}
