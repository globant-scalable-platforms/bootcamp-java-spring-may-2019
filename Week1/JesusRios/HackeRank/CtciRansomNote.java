import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CtciRansomNote {

    // Complete the checkMagazine function below.
    static String checkMagazine(String[] magazine, String[] note) {
        boolean found = false;
        for (int i = 0; i < note.length; i++) {
            for (int j = 0; j < magazine.length; j++) {
                if (note[i].equals(magazine[j])) {
                    magazine[j] = "1";
                } else {
                    return "No";
                }
            }
        }
        return "Yes";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        String result = checkMagazine(magazine, note);

        scanner.close();
    }
}
