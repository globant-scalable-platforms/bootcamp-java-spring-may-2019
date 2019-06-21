/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mapComparison;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        List<Long> hashMapRegister = new ArrayList<Long>();
        List<Long> treeMapRegister = new ArrayList<Long>();

        Map<Integer,Integer> hashMap = new HashMap<>();
        hashMapRegister.add(addElements(hashMap));

        Map<Integer,Integer> treeMap = new TreeMap<>();
        treeMapRegister.add(addElements(treeMap));

        hashMapRegister.add(findElementByKey(hashMap));
        treeMapRegister.add(findElementByKey(treeMap));

        hashMapRegister.add(removeElementByKey(hashMap));
        treeMapRegister.add(removeElementByKey(treeMap));

        hashMapRegister.add(addElementKeyValue(hashMap));
        treeMapRegister.add(addElementKeyValue(treeMap));

        hashMapRegister.add(iterateMapKeys(hashMap));
        treeMapRegister.add(iterateMapKeys(treeMap));

        hashMapRegister.add(iterateMapValues(hashMap));
        treeMapRegister.add(iterateMapValues(treeMap));

        hashMapRegister.add(iterateMapEntry(hashMap));
        treeMapRegister.add(iterateMapEntry(treeMap));

        /* --- Print Results*/
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("The result for the HashMap are: ");
        printResult(hashMapRegister);
        System.out.println("----------------------------------");

        System.out.println("The result for the TreeMap are: ");
        printResult(treeMapRegister);
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        
    }

    public static void populate(Map<Integer,Integer> objects, int amount){
        for(int i=0; i< amount; i++){
            if((i!=0) && (i%2==1)){
                i = -i;
            }
            objects.put(i,i);
            i = Math.abs(i);
        }
    }

    private static long addElements(Map<Integer,Integer> objects){
        long start = System.nanoTime();
        populate(objects, 10000000);
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long findElementByKey(Map<Integer,Integer> objects){
        long start = System.nanoTime();
        objects.get(0);
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long removeElementByKey(Map<Integer, Integer> objects){
        long start = System.nanoTime();
        objects.remove(0);
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long addElementKeyValue(Map<Integer, Integer> objects){
        long start = System.nanoTime();
        objects.put(0,0);
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long iterateMapKeys(Map<Integer,Integer> objects){
        long start = System.nanoTime();
        for(Integer key: objects.keySet()){

        }
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long iterateMapValues(Map<Integer,Integer> objects){
        long start = System.nanoTime();
        for(Integer value: objects.values()){

        }
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long iterateMapEntry(Map<Integer,Integer> objects){
        long start = System.nanoTime();
        for(Map.Entry<Integer,Integer> entry: objects.entrySet()){

        }
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static void printResult(List<Long> listResult){
        System.out.println(" Add elements: " + listResult.get(0) + " Miliseconds");
        System.out.println(" Find element: " + listResult.get(1) + " Miliseconds");
        System.out.println(" Remove element: " + listResult.get(2) + " Miliseconds");
        System.out.println(" Add one element: " + listResult.get(3) + " Miliseconds");
        System.out.println(" Iterate keys: " + listResult.get(4) + " Miliseconds");
        System.out.println(" Iterate values: " + listResult.get(5) + " Miliseconds");
        System.out.println(" Iterate entry: " + listResult.get(6) + " Miliseconds");
    }

}
