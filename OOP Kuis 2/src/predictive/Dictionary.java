package predictive;

import java.util.Set;

public interface Dictionary {
	/**
	 * Interface for type dictionary
	 */
	String wordToSignature(String word);

	/**
	 * Method to get all words in dictionary with a certain signature
	 * save all word that have same signature
	 */
	Set<String> signatureToWords(String signature);
}
