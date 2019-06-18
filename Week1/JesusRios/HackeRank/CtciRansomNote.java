import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CtciRansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        boolean found = false;
        aqui:
        for (int i = 0; i < note.length; i++) {
            found = false;
            for (int j = 0; j < magazine.length; j++) {
                if (note[i].equals(magazine[j])) {
                    magazine[j] = "1";
                    found = true;
                    continue aqui;
                } else {
                    found = false;
                }
            }
            if (!found) {
                System.out.println("No");
                return;
            }

        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
/*        String[] mn = scanner.nextLine().split(" ");

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

        checkMagazine(magazine, note);*/

        String[] magazine1 = {"give", "me", "one", "grand", "today", "night"};
        String[] note1 = {"give", "one", "grand", "today"};
        checkMagazine(magazine1, note1);


        //scanner.close();
    }
}
