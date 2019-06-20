import java.util.*;
import java.util.List;

public class ComparisonUtils {

    //Methods ArrayList vs LinkedList
    public static Double addingValues(List<Integer> objects, Integer[] collectionData) {

        long start = System.nanoTime();

        for (int i = 0; i< collectionData.length; i++){
            objects.add(i);
        }

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }

    public static Double removingValuesFromMiddle(List<Integer> objects, Integer[] collectionData) {

        for (int i = 0; i< collectionData.length; i++){
            objects.add(i);
        }

        long start = System.nanoTime();

        while (objects.size() > 0){
            objects.remove(objects.size()/2);
        }

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }

    public static Double addingValuesInMiddle(List<Integer> objects, Integer[] collectionData) {

        long start = System.nanoTime();

        for (int i = 0; i< collectionData.length; i++){
            objects.add(objects.size()/2, i);
        }

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }

    public static Double iterateCollection(List<Integer> objects, Integer[] collectionData) {

        for (int i = 0; i< collectionData.length; i++){
            objects.add(i);
        }

        long start = System.nanoTime();

        for (Integer i: objects){
        }

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }

    public static Double sortCollection(List<Integer> objects, Integer[] collectionData) {

        for (int i = 0; i< collectionData.length; i++){
            objects.add(i);
        }

        long start = System.nanoTime();

        objects.sort(Comparator.naturalOrder());

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }


    //Methods HashMap vs TreeMap
    public static Double putNewElement(Map<Integer, String> objects, Integer[] collectionData){

        long start = System.nanoTime();

        for (int i = 0; i< collectionData.length; i++){
            objects.put(i,"" + i);
        }

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }

    public static Double findElementByKey(Map<Integer, String> objects, Integer[] collectionData){

        for (int i = 0; i< collectionData.length; i++){
            objects.put(i,"" + i);
        }

        long start = System.nanoTime();

        for (int i = 0; i< collectionData.length; i++){
            objects.get(i);
        }

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }

    public static Double removeElementByKey(Map<Integer, String> objects, Integer[] collectionData){

        for (int i = 0; i< collectionData.length; i++){
            objects.put(i,"" + i);
        }

        long start = System.nanoTime();

        for (int i = 0; i< collectionData.length; i++){
            objects.remove(i);
        }

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }

    public static Double iterateEntries(Map<Integer, String> objects, Integer[] collectionData){

        for (int i = 0; i< collectionData.length; i++){
            objects.put(i,"" + i);
        }

        long start = System.nanoTime();

        for(Map.Entry<Integer, String> value: objects.entrySet()){
        }

        long end = System.nanoTime();

        return ((end - start)/1000000.0);
    }

}
