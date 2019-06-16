import java.util.*;

class PutElements{
    private static final int runs = 10;

    public static void main(String[] args){
        Double[] resultHashMap = new Double[runs];
        Double[] resultTreeMap = new Double[runs];

        Long start, end;

        for(int i = 0; i < runs; i++){
            String[] keys = new String[1000000];
            fillWithRandom(keys);

            Map<String, Boolean> hashMap = new HashMap<>();

            start = System.nanoTime();
            for(String cur : keys)
                hashMap.put(cur, true);
            end = System.nanoTime();

            resultHashMap[i] = (end - start) / 1000000.0;

            SortedMap<String, Boolean> treeMap = new TreeMap<>();

            start = System.nanoTime();
            for(String cur : keys)
                treeMap.put(cur, true);
            end = System.nanoTime();

            resultTreeMap[i] = (end - start) / 1000000.0;

            System.out.println("| " + i + "    |" + resultHashMap[i] + "|" + resultTreeMap[i] + "|");
        }
    }

    private static void fillWithRandom(String[] toFill){
        for(int i = 0; i < toFill.length; i++){
            toFill[i] = UUID.randomUUID().toString();
        }
    }
}