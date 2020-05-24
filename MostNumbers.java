// Raja Hammad Mehmood
// This program is a game which asks for the most frequent number in a given set of numbers. In case 
// it's wrong, the program removes it otherwise you win.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MostNumbers {
	public static void main(String[] args) {
		LinkedList<Integer> board = new LinkedList<Integer>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			count.add(0);
		}
		for (int i = 0; i < 20; i++) {
			int n = (int) (Math.random() * (9 + 1));
			board.add(n);
			count.set(n, count.get(n) + 1);
		}
		int maxoccurance = 0;
		int max = 0;
		for (int i = 0; i < 10; i++) {
			if (count.get(i) > maxoccurance) {
				maxoccurance = count.get(i);
				max = i;
			}
		}

		while (true) {

			for (Integer n : board) {
				System.out.print(n + " ");

			}
			System.out.println();
			System.out.println("Enter your guess for most frequent number (negative to quit): ");
			int number = scanner.nextInt();
			if (number < 0) {
				break;
			} else if (number == max) {
				System.out.print("YOU WON!!!");
				break;
			} else {
				System.out.println("Incorrect. I'm removing that number. Next Player");
				System.out.println();
				while (board.contains(number)) {
					board.remove(((Integer) number));
				}
			}
		}

	}
}
