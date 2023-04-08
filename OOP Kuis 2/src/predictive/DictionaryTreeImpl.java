package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DictionaryTreeImpl implements Dictionary {
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

	// setDictionaryWords used to store all words that have the match signature
	private Set<String> setDictionaryWords = null;
	// array to store next node (or child node)
	// the size is 8 (node have 8 child) because representing signature of next
	// character
	// index [0] is signature 2, index [1] is signature 3,...., last index[7] is
	// signature 9
	// So, this array to represent signature of next character from signature 2
	// until 9
	private DictionaryTreeImpl nextNode[] = new DictionaryTreeImpl[8];

	/**
	 * Constructor of the dictionary tree, this will create the full tree containing
	 * all valid words from dictionary file
	 */
	public DictionaryTreeImpl(String path) {
		if (path != null) {
			try {
				// BufferedReader used because it is faster than Scanner cause read each line of
				// file
				BufferedReader fileReader = new BufferedReader(new FileReader(path));

				// string that used to store word that have been read from file
				String storeWord = null;

				while ((storeWord = fileReader.readLine()) != null) {
					// changed to lower case for easier comparison and because
					// all words need to stored in lower case
					storeWord = storeWord.toLowerCase();

					// must check is the word not contain non alphabet, because
					// words that contain non alphabet doesn't need to be stored
					// and can't be retrieved even if stored
					if (isValidWord(storeWord) && storeWord.length() > 0) {
						// store the word in tree
						this.insertNext((short) -1, storeWord);
					}
				}

				// Don't forget to close the BufferedReader
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Recursive method to insert node to the tree,and this tree could make 10 node
	 * to reach the required location of leaf
	 */
	private void insertNext(short depth, String words) {
		if (depth == words.length() - 1) {
			// this node represent the last signature of the word
			// because this is the last index, the word stored in this setDictionaryWords
			// initialize setDictionaryWords if not yet initialized
			// don't forget, this could lead to exception
			if (this.setDictionaryWords == null) {
				// HashSet used because it is faster for lookup than TreeSet (O(log n) because
				// self balancing tree)
				// and LinkedHashSet (similar to HashSet but use LinkedList for collision)
				// HashSet use hashing and collision stored in self balancing tree
				this.setDictionaryWords = new HashSet<String>();
			}

			setDictionaryWords.add(words);
		} else if (this.nextNode[signatureOfChar[words.charAt(depth + 1) - 'a'] - '2'] == null) {
			// the if condition may be really hard to understand, here's explanation
			// it's basically check is the next node that represent next signature still
			// null (not exist)
			// this.depth + 1 represent next character index
			// it takes character at this.depth + 1 index and subtracted by 'a'
			// to become index for signatureOfChar (this actually convert char into
			// signature)
			// then the char of index subtracted by '2' to get index for nextNode
			// because nextNode first index to represent signature '2'
			// because it is null, then it must be created first and then walk again to
			// the required location of the leaf
			this.nextNode[signatureOfChar[words.charAt(depth + 1) - 'a'] - '2'] = new DictionaryTreeImpl(null);
			this.nextNode[signatureOfChar[words.charAt(depth + 1) - 'a'] - '2'].insertNext((short) (depth + 1), words);
		} else {
			// because next node already exist, it just need to call this recursive again
			this.nextNode[signatureOfChar[words.charAt(depth + 1) - 'a'] - '2'].insertNext((short) (depth + 1), words);
		}
	}

	/**
	 * Method to get words with a certain signature that exist in dictionary file
	 * this function do search by the prefix of a signature of a word and trimmed to
	 * the length of the signature
	 */
	private Set<String> getWordsFromSignature(String signature, short length) {
		if (signature.length() == 0) {
			// this means, this node is the node for last signature
			// then it just need to add all words that stored by the sub branch tree node

			// HashSet to store all words with the same prefix
			Set<String> allWordsWithSamePrefix = new HashSet<String>();
			if (this.setDictionaryWords != null) {
				// don't forget to add the current node words if it is exist
				for (String element : this.setDictionaryWords) {
					allWordsWithSamePrefix.add(element.substring(0, length));
				}
			}

			// add all element that have the same prefix from next node
			for (DictionaryTreeImpl nextNodeElement : this.nextNode) {
				// don't forget to check is the next node exist, if not this could lead to
				// exception
				if (nextNodeElement != null) {
					for (String nextNodeStringElement : nextNodeElement.getWordsFromSignature(signature, length)) {
						// add all words with same prefix and the length trimmed to the length of
						// signature
						allWordsWithSamePrefix.add(nextNodeStringElement.substring(0, length));
					}
				}
			}
			return allWordsWithSamePrefix;
		} else if (this.nextNode[signature.charAt(0) - '2'] != null) {
			// this condition is to traversing to the desired tree node that represent the
			// prefix signature
			// the first index signature is pop out to get the next signature character
			return this.nextNode[signature.charAt(0) - '2'].getWordsFromSignature(signature.substring(1), length);
		}

		// return empty HashSet if the signature doesn't exist in dictionary
		return new HashSet<String>();
	}

	@Override
	public String wordToSignature(String word) {

		StringBuffer signatureStringBuffer = new StringBuffer("");

		// the word must not null to be converted
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
		// all signature character must numeric with range from 2-9, if not then no need
		// to convert it
		// because it can't be converted (1 doesn't used because not representing any
		// alphabet) and no
		// word will be represented by that signature
		if (signature.length() > 0 && isNumericWord(signature)) {
			return this.getWordsFromSignature(signature, (short) signature.length());
		}

		// return empty HashSet if the signature isn't valid (containing non numeric
		// characters)
		// or the signature is empty (this must be done because if not, the empty
		// signature will return
		// non empty set with just one element that is an empty string or "", not null,
		// this happen
		// because this class search by prefix, not by fixed signature)
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