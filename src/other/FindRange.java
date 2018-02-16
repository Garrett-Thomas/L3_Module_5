package other;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindRange {
	static ArrayList<Integer> ints = new ArrayList<Integer>();

	public static void main(String[] strings) {
		int stop = -1;
		Scanner aidan = new Scanner(System.in);
		while (stop != 0) {
			stop = aidan.nextInt();
			if (stop == 0) {
				stop = 0;
			}
			else {
			ints.add(aidan.nextInt());
			}
		}


	}

	public void findLargest() {
		int bigNum = ints.get(0);
		for (int i = 0; i < ints.size(); i++) {
			if (ints.get(i) > bigNum) {
				bigNum = ints.get(i);
			}
		}
		System.out.println("Largest: " + bigNum);

	}
	public void findSmallest() {
		int smallNum = ints.get(0);
		for (int i = 0; i < ints.size(); i++) {
			if (ints.get(i) < smallNum) {
				smallNum = ints.get(i);
			}
		}
		System.out.println("Smallest: " + smallNum);
	}
}
