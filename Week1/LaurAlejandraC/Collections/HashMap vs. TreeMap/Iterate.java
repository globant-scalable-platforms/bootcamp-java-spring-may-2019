import java.util.*;

class Iterate{
    private static final int runs = 10;

    public static void main(String[] args){
        Double[] resultHashMap = new Double[runs];
        Double[] resultTreeMap = new Double[runs];

        Long start, end;

        for(int i = 0; i < runs; i++){
            String[] keys = new String[1000000];
            fillWithRandom(keys);

            Map<String, Boolean> hashMap = new HashMap<>();
            SortedMap<String, Boolean> treeMap = new TreeMap<>();
            Iterator<Map.Entry<String, Boolean>> itr;

            for(String cur : keys){
                hashMap.put(cur, true);
                treeMap.put(cur, true);
            }

            start = System.nanoTime();
            itr = hashMap.entrySet().iterator();
            while(itr.hasNext())
                itr.next();
            end = System.nanoTime();

            resultHashMap[i] = (end - start) / 1000000.0;

            start = System.nanoTime();
            itr = treeMap.entrySet().iterator();
            while(itr.hasNext())
                itr.next();
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