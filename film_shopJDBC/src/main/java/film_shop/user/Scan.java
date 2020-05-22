package film_shop.user;

import java.util.Scanner;

public class Scan {

	static Scanner scanner = new Scanner(System.in);

	public static String input() {

		return scanner.nextLine(); // can use for everything then cast for type needed.

	}

	public static int inputInt() {

		int input;
		input = scanner.nextInt();
		scanner.nextLine(); // have to eat next line
		return input;

	}

	public static float inputFloat() {

		float input;
		input = scanner.nextFloat();
		scanner.nextLine();
		return input;
	}

}
