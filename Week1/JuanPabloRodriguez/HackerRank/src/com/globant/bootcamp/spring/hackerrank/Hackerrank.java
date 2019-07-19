/**
 * 
 */
package com.globant.bootcamp.spring.hackerrank;

import java.util.*;

/**
 * @author Juan Pablo
 *
 */
public class Hackerrank {

	static String checkMagazine(String[] magazine, String[] note) {
		List magazineList = new ArrayList(Arrays.asList(magazine));
		List noteList = new ArrayList(Arrays.asList(note));

		while (noteList.isEmpty() != true) {
			if (magazineList.contains(noteList.get(0))) {
				magazineList.remove(noteList.get(0));
				noteList.remove(0);
			} else {
				return "No";
			}
		}

		if (noteList.isEmpty()) {
			return "Yes";
		}
		return null;

	}

	public static void main(String[] args) {

		// TEST 1

		int m = 7;
		int n = 6;

		String[] magazine = new String[m];

		String magazineExample1 = "I am looking for paradise two two";

		String[] magazineItems = magazineExample1.split(" ");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String noteExample1 = "I am looking for two two";

		String[] noteItems = noteExample1.split(" ");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}
		System.out.println("TEST 1");
		System.out.println("Magazine: " + magazineExample1);
		System.out.println("Note: " + noteExample1);
		System.out.println("Should be Yes");
		System.out.println("Answer: " + checkMagazine(magazine, note));

		// TEST 2

		m = 6;
		n = 6;

		magazine = new String[m];

		magazineExample1 = "I am looking for paradise two";

		magazineItems = magazineExample1.split(" ");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		note = new String[n];

		noteExample1 = "I am looking for two two";

		noteItems = noteExample1.split(" ");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		System.out.println("TEST 2");
		System.out.println("Magazine: " + magazineExample1);
		System.out.println("Note: " + noteExample1);
		System.out.println("Should be No");
		System.out.println("Answer: " + checkMagazine(magazine, note));

		// TEST 3

		m = 7;
		n = 4;

		magazine = new String[m];

		magazineExample1 = "ive got a lovely bunch of coconuts";

		magazineItems = magazineExample1.split(" ");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		note = new String[n];

		noteExample1 = "ive got some coconuts";

		noteItems = noteExample1.split(" ");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		System.out.println("TEST 3");
		System.out.println("Magazine: " + magazineExample1);
		System.out.println("Note: " + noteExample1);
		System.out.println("Should be No");
		System.out.println("Answer: " + checkMagazine(magazine, note));

		// TEST 4

		m = 6;
		n = 4;

		magazine = new String[m];

		magazineExample1 = "give me one grand today night";

		magazineItems = magazineExample1.split(" ");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		note = new String[n];

		noteExample1 = "give one grand today";

		noteItems = noteExample1.split(" ");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		System.out.println("TEST 4");
		System.out.println("Magazine: " + magazineExample1);
		System.out.println("Note: " + noteExample1);
		System.out.println("Should be Yes");
		System.out.println("Answer: " + checkMagazine(magazine, note));

	}
}
