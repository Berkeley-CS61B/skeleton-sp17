package p2.codeSamples;

public class DemoCardSuits {
	/** Brief demonstration of how enums work in Java.
	 *  Enums can either be created directly using
	 *  dot notation, or can be created using valueOf notation.
	 */
	public static void main(String[] args) {
		CardSuits[] someSuits = new CardSuits[3];
		
		someSuits[0] = CardSuits.DIAMONDS;
		someSuits[1] = CardSuits.HEARTS;
		someSuits[2] = CardSuits.valueOf("SPADES");

		System.out.println(someSuits[0]);
		System.out.println(someSuits[1]);
		System.out.println(someSuits[2]);

		if (someSuits[1] == CardSuits.HEARTS) {
			System.out.println("Card 1 is a HEART");
		}
	}
} 