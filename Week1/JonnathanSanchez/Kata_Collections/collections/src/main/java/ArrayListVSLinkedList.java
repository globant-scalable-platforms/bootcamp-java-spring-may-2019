import java.util.*;


public class ArrayListVSLinkedList {

    public static void main(String[] args){
        //Comparison ArrayList vs LinkedList
        Double result;
        int amount = 100000;
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

        //Calculate time adding sequentially values in ArrayList
        result = ComparisonUtils.addingValues(new ArrayList<>(), sequentiallyData);

        System.out.println("ArrayList vs LinkedList --> " + amount + " elements");
        System.out.println();
        System.out.println("Adding sequentially values");
        System.out.println("ArrayList --> Time (Miliseconds): " + result);

        //Calculate time adding sequentially values in LinkedList
        result = ComparisonUtils.addingValues(new LinkedList<>(), sequentiallyData);

        System.out.println("LinkedList --> Time (Miliseconds): " + result);

        //Calculate time adding random values in ArrayList
        result = ComparisonUtils.addingValues(new ArrayList<>(), randomData);

        System.out.println("Adding random values");
        System.out.println("ArrayList --> Time (Miliseconds): " + result);

        //Calculate time adding random values in LinkedList
        result = ComparisonUtils.addingValues(new LinkedList<>(), randomData);

        System.out.println("LinkedList --> Time (Miliseconds): " + result);

        //Calculate time removing an element from ArrayList
        result = ComparisonUtils.removingValuesFromMiddle(new ArrayList<>(), randomData);

        System.out.println("Removing an element from middle");
        System.out.println("ArrayList --> Time (Miliseconds): " + result);

        //Calculate time removing an element from LinkedList
        result = ComparisonUtils.removingValuesFromMiddle(new LinkedList<>(), randomData);

        System.out.println("LinkedList --> Time (Miliseconds): " + result);

        //Calculate time adding elements in the middle ArrayList
        result = ComparisonUtils.addingValuesInMiddle(new ArrayList<>(), randomData);

        System.out.println("Adding element in the middle");
        System.out.println("ArrayList --> Time (Miliseconds): " + result);

        //Calculate time adding elements in the middle LinkedList
        result = ComparisonUtils.addingValuesInMiddle(new LinkedList<>(), randomData);

        System.out.println("LinkedList --> Time (Miliseconds): " + result);

        //Calculate time iterating elements  ArrayList
        result = ComparisonUtils.iterateCollection(new ArrayList<>(), randomData);

        System.out.println("Iterating elements");
        System.out.println("ArrayList --> Time (Miliseconds): " + result);

        //Calculate time iterating elements LinkedList
        result = ComparisonUtils.iterateCollection(new LinkedList<>(), randomData);

        System.out.println("LinkedList --> Time (Miliseconds): " + result);

        //Calculate time sorting elements  ArrayList
        result = ComparisonUtils.sortCollection(new ArrayList<>(), randomData);

        System.out.println("Sorting elements");
        System.out.println("ArrayList --> Time (Miliseconds): " + result);

        //Calculate time sorting elements LinkedList
        result = ComparisonUtils.sortCollection(new LinkedList<>(), randomData);

        System.out.println("LinkedList --> Time (Miliseconds): " + result);

    }


}

