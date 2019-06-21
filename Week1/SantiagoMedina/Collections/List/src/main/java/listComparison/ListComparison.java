package listComparison;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListComparison {
    public static void main(String[] args){
        //Creation

        /* --- Registers --- */
        List<Long> arrayListRegister = new ArrayList<Long>();
        List<Long> linkedListRegister = new ArrayList<Long>();


        /* --- Add Elements --- */
        List<Integer> arrayList = new ArrayList<Integer>();
        arrayListRegister.add(addElements(arrayList));
        List<Integer> linkedList = new LinkedList<Integer>();
        linkedListRegister.add(addElements(linkedList));

        /* --- Remove Middle Element ---*/
        arrayListRegister.add(removeElementMiddle(arrayList,middle(arrayList)));
        linkedListRegister.add(removeElementMiddle(linkedList,middle(linkedList)));

        /* --- Add Middle Element --- */
        arrayListRegister.add(addElementMiddle(arrayList,middle(arrayList)));
        linkedListRegister.add(addElementMiddle(linkedList,middle(linkedList)));

        /* --- Iterate List --- */
        arrayListRegister.add(iterateList(arrayList));
        linkedListRegister.add(iterateList(linkedList));

        /* --- Sort List --- */
        arrayListRegister.add(sortList(arrayList));
        linkedListRegister.add(sortList(linkedList));

        /* --- Print Results*/
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        System.out.println("The result for the ArrayList are: ");
        printResult(arrayListRegister);
        System.out.println("----------------------------------");

        System.out.println("The result for the LinkedList are: ");
        printResult(linkedListRegister);
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");

    }

    private static List<Integer> populate(List<Integer> objects, int amount) {
        return new Random()
                .ints()
                .limit(amount)
                .boxed()
                .collect(Collectors.toCollection(() -> objects));
    }

    private static long addElements(List<Integer> objects){
        long start = System.nanoTime();
        populate(objects, 10000000);
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long removeElementMiddle(List<Integer> objects, int middle){
        long start = System.nanoTime();
        objects.remove(middle);
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long addElementMiddle(List<Integer> objects, int middle){
        Integer element = 4;
        long start = System.nanoTime();
        objects.add(middle,element);
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long iterateList(List<Integer> objects){
        long start = System.nanoTime();
        for (Integer element:objects){

        }
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static long sortList(List<Integer> objects){
        long start = System.nanoTime();
        objects.sort(Comparator.naturalOrder());
        long end = System.nanoTime();
        return ((end-start)/1000000);
    }

    private static int middle(List<Integer> objects){
        int middle = ((objects.size()-1)/2) + ((objects.size()-1)%2);
        return middle;
    }

    private static void printResult(List<Long> listResult){
        System.out.println(" Add elements: " + listResult.get(0) + " Miliseconds");
        System.out.println(" Remove middle element: " + listResult.get(1) + " Miliseconds");
        System.out.println(" Add middle element: " + listResult.get(2) + " Miliseconds");
        System.out.println(" Iterate list: " + listResult.get(3) + " Miliseconds");
        System.out.println(" Sort list: " + listResult.get(4) + " Miliseconds");
    }

}