package Katas_Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class streamMain {
	final static int ITEMS = 100;

	public static void main(String[] args) {

		// REDUCING
		/*
		 * Optional<Integer> sum; ArrayList<Integer> list = createArr(ITEMS); //
		 * Initialize array sum = list.stream().reduce((a, b) -> a + b); // Reducing The
		 * Array System.out.println("Total " + sum); // Showing Result Total Optional
		 * [4096] System.out.println("Total " + summingArrayElements(list)); //
		 * Comparing Result against classic method Total 4096
		 */
		//

		// DELETE DUPLICATES
		/*ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 4, 5, 5, 6, 6, 7, 8, 2)); // Initialize
																												// array
		list.stream().distinct().collect(Collectors.toList()).forEach(System.out::print); // Printing and holding unique
																							// values

		*/
	}

	public static ArrayList<Integer> createArr(int val) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i < val; i++) {
			temp.add((int) (Math.random() * 100));
		}
		return temp;
	}

	public static int summingArrayElements(ArrayList<Integer> list) {
		int cont = 0;
		for (int num : list) {
			cont += num;
		}
		return cont;
	}

	public static void printArr(ArrayList<Integer> list) {
		list.forEach(System.out::println);
	}
}
