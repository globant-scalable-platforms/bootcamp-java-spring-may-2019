import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] magazine = reader.readLine().split(" ");
        String[] note = reader.readLine().split(" ");

        Map<String, Integer> available = new HashMap<>();

        boolean possible = true;

        for(String cur : magazine){
            if(!available.containsKey(cur))
                available.put(cur, 1);
            else
                available.put(cur, available.get(cur)+1);
        }

        for(String cur : note){
            if(!available.containsKey(cur) || available.get(cur) <= 0){
                possible = false;
                break;
            }
            else
                available.put(cur, available.get(cur) - 1);
        }

        System.out.println(possible ? "Yes" : "No");
    }
}