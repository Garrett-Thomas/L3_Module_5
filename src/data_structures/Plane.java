package data_structures;

import java.util.ArrayList;

public class Plane {
	Randomness rand = new Randomness();
	int numberOfPassengers = 1;
	ArrayList<Snake> snakes = new ArrayList<Snake>();

	public static void main(String[] args) {
		Plane plen = new Plane();
		plen.method();
	}

	public void method() {
		for (int i = 0; i < 100; i++) {
			snakes.add(new Snake(rand.intRand(), rand.boolRand()));
		}
		urDeadBuddy();
	}

	public void urDeadBuddy() {
		int totalVic = 0;
		for (int i = 0; i < 100; i++) {
			if (snakes.get(i).ven() == true) {
				totalVic = totalVic + snakes.get(i).vic();
			}
		}
		System.out.println("The chance of death is: " + ((totalVic * 10) / numberOfPassengers) + "%");
	}
}
