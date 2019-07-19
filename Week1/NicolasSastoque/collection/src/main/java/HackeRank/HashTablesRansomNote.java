package HackeRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HashTablesRansomNote {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Map<String, Integer> availableWords = new HashMap<>();

        for(String word: magazineItems){

            if(availableWords.containsKey(word)){
                availableWords.put(word, availableWords.get(word)+1);
            }
            else{
                availableWords.put(word, 1);
            }
        }

        String answer = "Yes";

        for(String word: noteItems){
            if(availableWords.containsKey(word) && availableWords.get(word) > 0){
                availableWords.put(word, availableWords.get(word)-1);
            }
            else {
                answer = "No";
                break;
            }
        }

        System.out.println(answer);

        scanner.close();
    }
}

