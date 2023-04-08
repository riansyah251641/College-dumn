package predictive;

public class Words2SigProto {

	public static void main(String[] args) {
		System.out.print("input : ");
		for (String argument : args) {
			System.out.print(argument + " ");
		}
		System.out.print("input : ");
		for (String argument : args) {
			System.out.print(PredictivePrototype.wordToSignature(argument) + " ");
		}
	}
}
