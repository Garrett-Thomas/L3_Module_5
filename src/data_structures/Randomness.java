package data_structures;

import java.util.Random;

public class Randomness {
	static Random randValue = new Random();

	public static boolean boolRand() {
		return randValue.nextBoolean();
	}

	public static int intRand() {
		return randValue.nextInt(10);
	}
}
