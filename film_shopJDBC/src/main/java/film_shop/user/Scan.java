package film_shop.user;

import java.util.Scanner;

public class Scan {

	static Scanner sc = new Scanner(System.in);

	static String input() {

		return sc.nextLine(); // can use for everything then cast for type needed.

	}

	static int inputInt() {

		int input;
		input = sc.nextInt();
		sc.nextLine(); // have to eat next line
		return input;

	}

}
