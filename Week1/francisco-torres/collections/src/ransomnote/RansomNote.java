package ransomnote;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	private static int numWordsMagazine = 0;
	private static int numWordsNote = 0;
	
	private static Map<String,Integer> magazineWords = new HashMap<>();
	private static Map<String,Integer> noteWords = new HashMap<>();
	
	public static void setSize(String amount) {
		String[] amounts = amount.split(" ");
		
		try {
			numWordsMagazine = Integer.parseInt(amounts[0]);
			numWordsNote = Integer.parseInt(amounts[1]);	
		} catch (NumberFormatException e) {
			System.out.println("the entered values are not numbers.");
		}
	}
	
	public static void setWordsMap(Map<String,Integer> wordsMap, String words, int size) {
		for (String string : words.split(" ")) {
			if (wordsMap.containsKey(string)) {
				wordsMap.put(string, wordsMap.get(string)+1);
			}
			else {
				wordsMap.put(string, 1);
			}
			
			if (wordsMap.size() >= size) {
				break;
			}
		}
	}
	
	public static boolean validateWordsRequired() {
		for (String key : noteWords.keySet()) {
			if(!magazineWords.containsKey(key)) {
	        	return false;
	        }
	        
	        if(magazineWords.get(key) < noteWords.get(key)) {
	        	return false;
	        }
	    }
		
		return true;
	}
	
	public static void main(String[] args) {
		BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in)); 
		
		try {
			setSize(bufferedReader.readLine());
			
			setWordsMap(magazineWords, bufferedReader.readLine(),numWordsMagazine);
			setWordsMap(noteWords, bufferedReader.readLine(), numWordsNote);
			
			System.out.println(validateWordsRequired()?"Yes":"No");
		} catch (ArrayIndexOutOfBoundsException e) {
	    } catch (IOException e) {
		}
	}
}
