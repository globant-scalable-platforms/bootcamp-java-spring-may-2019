package RansomNote;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        if (magazine.length < note.length) {
            System.out.print("No");
            return;
        }

        Map<String, Integer> wordsInMagazine = new HashMap<>();
        for (String word : magazine) {
            if (wordsInMagazine.containsKey(word)) {
                wordsInMagazine.put(word, wordsInMagazine.get(word) + 1);
            } else {
                wordsInMagazine.put(word, 1);
            }
        }

        for (String word : note) {
            if (wordsInMagazine.containsKey(word)) {
                int wordCount = wordsInMagazine.get(word);
                if (wordCount == 0) {
                    System.out.print("No");
                    return;
                } else {
                    wordsInMagazine.put(word, wordsInMagazine.get(word) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }

        System.out.print("Yes");
    }
}
