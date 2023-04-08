package predictive;

public class WordSig implements Comparable<WordSig> {
	private String word;
	private String signature;

	/**
	 * Constructor contain signature and the word to be pair with it's signature
	 */
	public WordSig(String signature, String word) {
		this.signature = signature;
		this.word = word;
	}

	/**
	 * Method get value of word with output value of word
	 */
	public String getWord() {
		return this.word;
	}

	/**
	 * Method get value of signature with output signature of the word
	 * 
	 * @return signature of the word
	 */
	public String getSignature() {
		return this.signature;
	}

	@Override
	/*
	 * comparison just by the signature of the word
	 * if have two different word will be count as same if the signature is
	 * identical
	 */
	public int compareTo(WordSig o) {
		return this.signature.compareTo(o.signature);
	}

}
