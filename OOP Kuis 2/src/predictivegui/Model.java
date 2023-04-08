package predictivegui;

import java.util.*;

import predictive.*;
import predictive.Dictionary;

public class Model extends Observable {
	/**
	 * Class for action of each button pressed
	 */

	// initialize variabel and object
	private String s = "";
	private static Dictionary dic = new DictionaryTreeImpl("assets/words");
	private List<String> currMatch;
	private List<String> signature = new ArrayList<String>();
	private String currString = "";
	private String response = "";
	private int i;

	// method for each button pressed
	public void press(char ch) {
		// if 0 pressed then create new word
		if (ch == '0') {
			// only make a new word when the current signature is not empty
			if (s.length() > 0)
				newWord();
		}
		// if * pressed change current word to the next word of the signature
		else if (ch == '*') {
			changeCurrentWord(); // change word
			getCurrentWord(); // get current word from signature
		}
		// if # pressed delete the last character from the signature
		else if (ch == '#') {
			delChar(); // delete character
			getCurrentWord(); // get current word from signature
		}
		// if 1 pressed then do nothing
		else if (ch == '1') {
		}
		// if 2 - 9 pressed then add them to the current signature
		else {
			addChar(ch); // add character to signature
			getCurrentWord(); // get current word from signature
		}

		// update the text field
		setChanged();
		notifyObservers(response + currString);
	}

	// method to add character to signature
	private void addChar(char ch) {
		s = s + ch;
		currMatch = new ArrayList<String>(dic.signatureToWords(s));
		i = 0;
	}

	// method to delete character from signature
	private void delChar() {
		// if the length of current signature is 0 and there at least 1
		// signature before the current siganture then take the last signature from
		// signature arraylist to be the current signature
		if (s.length() == 0 && signature.size() > 0) {

			s = signature.get(signature.size() - 1);
			signature.remove(signature.size() - 1);

			// delete the last signature from the text field string
			response = response.substring(0, response.length() - s.length() - 1);
		}
		// if the length of current signature is more than 0, then delete last character
		else if (s.length() > 0) {
			s = s.substring(0, s.length() - 1);
		}
		currMatch = new ArrayList<String>(dic.signatureToWords(s));
		i = 0;
	}

	// method to change the current word from the signature
	private void changeCurrentWord() {
		// increment current index
		i++;
		if (i == currMatch.size())
			i = 0;
	}

	// method to take certain word from the signature
	private void getCurrentWord() {
		// if there is word from the signature
		if (currMatch.size() > 0)
			currString = currMatch.get(i);
		// if there is no word from the signature
		else
			currString = s;
	}

	// method to make a new signature
	private void newWord() {
		// current signature for later use
		signature.add(s);
		s = "";

		// append the text field
		if (!currString.isEmpty()) {
			response = response + currString + " ";
		}
		currString = "";
	}
}
