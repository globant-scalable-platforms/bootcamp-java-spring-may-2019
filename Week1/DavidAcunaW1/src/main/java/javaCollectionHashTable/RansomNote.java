package javaCollectionHashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class RansomNote {
	public static void main(String[] args){
				
		String fileName = "config/input00.txt";
		
		List<String> list = new ArrayList<>();		
		Hashtable<String,Integer> ransomNote = new Hashtable<String,Integer>();

		try {			
			BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
			list = br.lines().collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
			
		Integer m = Integer.valueOf(list.get(0).split(" ")[0]);
		Integer n = Integer.valueOf(list.get(0).split(" ")[1]);		
		String[] revista = list.get(1).split(" ");
		String[] nota = list.get(2).split(" ");
		
		if(checkMagazine(m,n,revista,nota, ransomNote)) {
			System.out.println("Yes");			
		}else {
			System.out.println("No");
		}
		
	}

	private static Boolean checkMagazine(Integer m, Integer n, String[] revista, 
			String[] nota, Hashtable<String,Integer> ransomNote) {
		if(m>=1 && m<=3000 && n>=1 && n<=3000) {
			checkMagazineWords(revista, ransomNote);
			return canReplicate(nota, ransomNote);
		}
		return false;
	}

	private static void checkMagazineWords(String[] revista, Hashtable<String, Integer> ransomNote) {
		for(String s : revista){
			if(!ransomNote.containsKey(s)){	
				ransomNote.put(s,1);					
			}else{
				Integer value = ransomNote.get(s);
				ransomNote.put(s,++value);
			}
		}
	}
	
	private static Boolean canReplicate(String[] nota, Hashtable<String, Integer> ransomNote) {
		for(String s : nota){
			if(ransomNote.containsKey(s) && ransomNote.get(s) > 0){
				Integer available = ransomNote.get(s);
				ransomNote.put(s,--available);
			}else{
				return false;
			}
		}
		return true;
	}
}
