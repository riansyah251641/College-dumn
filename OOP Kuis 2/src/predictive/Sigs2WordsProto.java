package predictive;

public class Sigs2WordsProto {

	public static void main(String[] args) {
		long run = System.nanoTime();
		for (String argument : args) {
			System.out.println(argument + " : " + PredictivePrototype.signatureToWords(argument));
		}
		long stop = System.nanoTime();
		long timeprogram = stop - run;
		System.out.println("Execution time  with sigs2WordsProto : " + timeprogram + " nanoseconds");
	}
}
