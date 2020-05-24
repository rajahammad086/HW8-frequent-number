
/* Author: Chris Fietkiewicz
 Performs multiple timing tests of the "contains()" method using the following collection 
classes:
 1. LinkedList
 2. ArrayList
 3. TreeSet
*/
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.TreeSet;

public class Timing {
	public static void main(String[] args) {
		Long trials = 20000L;
		Long N = 30000L;
		long startTime, stopTime; // For recording start/stop times
		// ****************** ArrayList test ******************
		// Set up a sorted list with N items
		ArrayList<Long> array = new ArrayList<>();

		for (Long i = 1L; i <= N; i++)
			array.add(i); // Add to end of list

		for (int x = 0; x < 6; x++) { // Test multiple searches for highest value (N)
			System.out.print("N = " + N + ": ");
			startTime = System.currentTimeMillis();
			for (Long i = 1L; i <= trials; i++)
				array.contains(N);
			stopTime = System.currentTimeMillis();
			System.out.println("ArrayList time: " + (stopTime - startTime) + "milliseconds");
			for (Long i = N + 1; i <= N + 10000; i++)
				array.add(i); // Add to end of list
			N += 10000;
		}
		// ****************** LinkedList test ******************
		N = 10000L;
		// Set up a sorted list with N items
		LinkedList<Long> linked = new LinkedList<>();

		for (Long i = 1L; i <= N; i++)
			linked.add(i); // Add to end of list

		for (int x = 0; x < 6; x++) {// Test multiple searches for highest value (N)
			System.out.print("N = " + N + ": ");
			startTime = System.currentTimeMillis();
			for (Long i = 1L; i <= trials; i++)
				linked.contains(N);
			stopTime = System.currentTimeMillis();
			System.out.println("LinkedList time: " + (stopTime - startTime) + "milliseconds");
			for (Long i = N + 1; i <= N + 10000; i++)
				linked.add(i); // Add to end of list
			N += 10000;
		}
		// ****************** TreeSet test ******************
		N = 30000L;
		// Set up a sorted tree with N items
		TreeSet<Long> tree = new TreeSet<>();
		for (Long i = 1L; i <= N; i++)
			tree.add(i); // Add value and let TreeSet decide where to put it
		for (int x = 0; x < 6; x++) { // Test multiple searches for highest value (N)
			System.out.print("N = " + N + ": ");
			startTime = System.currentTimeMillis();
			for (Long i = 1L; i <= (trials + 20000000); i++)
				tree.contains(N);
			stopTime = System.currentTimeMillis();
			System.out.println("TreeSet time: " + (stopTime - startTime) + "milliseconds");
			for (Long i = N + 1; i <= N + 30000; i++)
				tree.add(i); // Add to end of list
			N += 30000;
		}
		System.out.println("Done");
	}
}
