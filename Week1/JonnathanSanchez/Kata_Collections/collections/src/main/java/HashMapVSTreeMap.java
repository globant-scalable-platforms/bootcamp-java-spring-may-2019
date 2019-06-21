import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class HashMapVSTreeMap {

    public static void main(String[] args) {
        //Comparison HashMap vs TreeMap
        Double result;
        int amount = 1000000;
        Integer[] sequentiallyData = new Integer[amount];

        //adding sequentially values
        for (int i=0; i < amount; i++){
            sequentiallyData[i] = i;
        }

        Random rand = new Random();
        Integer[] randomData = new Integer[amount];

        //adding random values
        for (int i=0; i < amount; i++) {
            randomData[i] = rand.nextInt(amount);
        }

        //Calculate time adding sequentially values in HashMap
        result = ComparisonUtils.putNewElement(new HashMap<>(), sequentiallyData);

        System.out.println("HashMap vs TreeMap --> " + amount + " elements");
        System.out.println();
        System.out.println("Adding sequentially values");
        System.out.println("HashMap --> Time (Miliseconds): " + result);

        //Calculate time adding sequentially values in TreeMap
        result = ComparisonUtils.putNewElement(new TreeMap<>(), sequentiallyData);

        System.out.println("TreeMap --> Time (Miliseconds): " + result);

        //Calculate time adding random values in HashMap
        result = ComparisonUtils.putNewElement(new HashMap<>(), randomData);

        System.out.println("Adding random values");
        System.out.println("HashMap --> Time (Miliseconds): " + result);

        //Calculate time adding random values in TreeMap
        result = ComparisonUtils.putNewElement(new TreeMap<>(), randomData);

        System.out.println("TreeMap --> Time (Miliseconds): " + result);

        //Calculate time finding elements values in HashMap
        result = ComparisonUtils.findElementByKey(new HashMap<>(), randomData);

        System.out.println("Finding elements by key");
        System.out.println("HashMap --> Time (Miliseconds): " + result);

        //Calculate time finding elements values in TreeMap
        result = ComparisonUtils.findElementByKey(new TreeMap<>(), randomData);

        System.out.println("TreeMap --> Time (Miliseconds): " + result);

        //Calculate time removing elements values in HashMap
        result = ComparisonUtils.removeElementByKey(new HashMap<>(), randomData);

        System.out.println("Removing elements by key");
        System.out.println("HashMap --> Time (Miliseconds): " + result);

        //Calculate time removing elements values in TreeMap
        result = ComparisonUtils.removeElementByKey(new TreeMap<>(), randomData);

        System.out.println("TreeMap --> Time (Miliseconds): " + result);

        //Calculate time iterating entries in HashMap
        result = ComparisonUtils.iterateEntries(new HashMap<>(), randomData);

        System.out.println("Iterating entries");
        System.out.println("HashMap --> Time (Miliseconds): " + result);

        //Calculate time iterating entries in TreeMap
        result = ComparisonUtils.iterateEntries(new TreeMap<>(), randomData);

        System.out.println("TreeMap --> Time (Miliseconds): " + result);

    }
}
