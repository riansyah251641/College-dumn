package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DictionaryMapImpl implements Dictionary {

	// make array signatureofchar to save all the alphabet a-z
	// where index[0] = a', index[1] ='b' , index[2] ='c' ,....., index[25] ='z'
	private char signatureOfChar[] = { '2', '2', '2',
			'3', '3', '3',
			'4', '4', '4',
			'5', '5', '5',
			'6', '6', '6',
			'7', '7', '7', '7',
			'8', '8', '8',
			'9', '9', '9', '9' };

	// mapDictionaryWords fuction is used to store all data in words.txt in
	// dictionary file
	private Map<String, Set<String>> mapDictionaryWords = new HashMap<String, Set<String>>();

	/**
	 * DisctionaryMapImpl is Constructor
	 * then all words in dictionary file have been read will be stored in
	 * mapDictionaryWords
	 */
	public DictionaryMapImpl() {

		try {
			// path used to read every line of dictionary file
			BufferedReader path = new BufferedReader(new FileReader("assets/words"));

			// kalimat used to store a line of string that have been read by path
			String kalimat = null;

			// read every line of dictionary file
			while ((kalimat = path.readLine()) != null) {
				// all words need to stored in lower case
				kalimat = kalimat.toLowerCase();

				// word containing non alphabet will be skipped
				if (isValidWord(kalimat)) {

					String kata = wordToSignature(kalimat);
					if (mapDictionaryWords.containsKey(kata) == false) {
						mapDictionaryWords.put(kata, new HashSet<String>());
					}
					mapDictionaryWords.get(kata).add(kalimat);
				}
			}
			path.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String wordToSignature(String word) {
		// signatureStringBuffer used to save make signature of the word
		// StringBuffer is used to make signature string rather than using String
		StringBuffer signatureStringBuffer = new StringBuffer("");

		// word must no null to be converted
		if (word == null) {
			return word;
		}
		word = word.toLowerCase(); // to the word become lower case so it's easier to converted

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
				signatureStringBuffer.append(signatureOfChar[word.charAt(i) - 'a']);
			} else {
				signatureStringBuffer.append(" "); // for non alphabet changed to " " (space)
			}
		}

		return signatureStringBuffer.toString();
	}

	@Override
	public Set<String> signatureToWords(String signature) {
		// must check if the signature is value (not containing non numeric characters)
		if (isNumericWord(signature) && mapDictionaryWords.containsKey(signature)) {
			return mapDictionaryWords.get(signature);
		}

		// return empty HashSet if the signature isn't valid (containing non numeric
		// characters)
		// or the key doesn't exist in the dictionary
		// maybe instead like this, it is better to throw exception(?)
		return new HashSet<String>();
	}

	/**
	 * Method to check if a string just contain alphabet characters
	 * 
	 * @param word : string to be checked
	 * @return true if the word just contain alphabet character (lower case),
	 *         false if it contain non alphabet character (lower case)
	 */
	private boolean isValidWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) < 'a' || word.charAt(i) > 'z') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Method to check if a string contain non numerical
	 * 
	 * @param word : string to be checked
	 * @return true if string just contain numeric, false if there's one or more non
	 *         numeric in string
	 */
	private boolean isNumericWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) < '2' || word.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
}
