package predictive;

import java.util.Set;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class DictionaryListImpl {

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

	// listDictionaryWords used save all words that have been read from
	// dictionary with it's signature
	// Create ArrayList Object with WordSig element -WordSig detail explained on
	// WordSig class
	private List<WordSig> listDictionaryWords = new ArrayList<WordSig>();

	/**
	 * DistionaryListIlpl as a Constructor
	 * then all words in dictionary file have been read will be stored in
	 * listDictionaryWords
	 */
	public DictionaryListImpl() {

		// store all words in dictionary to list dictionary
		try {
			// path used to read every line of dictionary file
			// BufferedReader is faster than Scanner when read file line one by one
			BufferedReader path = new BufferedReader(new FileReader("assets/words"));

			// kalimat used to store every line read by path
			String kalimat = null;
			// reading every line of dictionary
			while ((kalimat = path.readLine()) != null) {
				// changed all input to lower case for easier comparison
				kalimat = kalimat.toLowerCase();
				// skip the word if with non alphabet
				if (this.isValidWord(kalimat)) {
					listDictionaryWords.add(new WordSig(this.wordToSignature(kalimat), kalimat));
				}
			}
			path.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// listDictionaryWords must be sorted because method signatureToWords use binary
		// search but just in case this will be sorted using Collections.
		Collections.sort(listDictionaryWords);
	}

	/**
	 * Convert a string of word to a signature (number)
	 * 
	 * input word : String of word that will be converted to its signature
	 * output signature of converted word
	 * for example if the word is "Home" become signature "4663" not "44666633"
	 */
	public String wordToSignature(String word) {
		// signatureStringBuffer used to save make signature of the word
		// StringBuffer is used to make signature string rather than using String
		StringBuffer signatureStringBuffer = new StringBuffer("");

		// word must not null to be converted
		if (word == null) {
			return word;
		}
		word = word.toLowerCase(); // to all of the the word become lower case

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
				signatureStringBuffer.append(signatureOfChar[word.charAt(i) - 'a']);
			} else {
				signatureStringBuffer.append(" "); // for non alphabet changed to " " (space)
			}
		}

		return signatureStringBuffer.toString();
	}

	/**
	 * signatureToWords is Method to read signature into a all list word that exist
	 * in words.txt
	 * input string number of signature than will read to word
	 * output Set all possible word with appropiate with signature
	 */
	public Set<String> signatureToWords(String signature) {

		if (isNumericWord(signature) && signature.length() > 0) {
			// Set containing all possible word of a signature that exist in dictionary
			// search just by signature, the word of signature doesn't important in search
			// algorithm
			Set<String> matchedPossibleWord = new HashSet<String>();
			WordSig searchKey = new WordSig(signature, "");
			int indexFound = Collections.binarySearch(listDictionaryWords, searchKey);

			// if indexFound < 0, that means the signature doesn't exist
			if (indexFound >= 0) {
				matchedPossibleWord.add(listDictionaryWords.get(indexFound).getWord());
				int indexupper = indexFound + 1;
				int indexbottom = indexFound - 1;

				// search to up in dicctionary
				while (indexupper < listDictionaryWords.size() &&
						listDictionaryWords.get(indexupper).compareTo(searchKey) == 0) {
					matchedPossibleWord.add(listDictionaryWords.get(indexupper).getWord());
					indexupper += 1;
				}

				// search down in dictionary
				while (indexbottom >= 0 &&
						listDictionaryWords.get(indexbottom).compareTo(searchKey) == 0) {
					matchedPossibleWord.add(listDictionaryWords.get(indexbottom).getWord());
					indexbottom -= 1;
				}
			}

			return matchedPossibleWord;
		}

		// return empty set if the signature contain non numerical
		// or the signature is empty
		return new HashSet<String>();
	}

	/**
	 * Function isValidWord check if a string just contain alphabet characters lower
	 * case
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
	 * isNumericWord is a fuction to check if a string contain just contain
	 * number.
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
