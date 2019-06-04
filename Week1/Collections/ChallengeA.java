import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChallengeA {
    public static void main(String[] args){
        //Creation

        List<Integer> arrayList = populate(new ArrayList<Integer>(), 10000000);
        List<Integer> linkedList = populate(new LinkedList<Integer>(), 10000000);
        int sizeArray = arrayList.size();
        int sizeLinked = linkedList.size();
        long timeArray = 0;
        long timeLinked = 0;

        long start = System.nanoTime();

        arrayList.add(69);

        long end = System.nanoTime();
        timeArray = end - start;

        System.out.println("ArrayList Time Adding (Nanoseconds): " + timeArray);

        start = System.nanoTime();

        linkedList.add(69);

        end = System.nanoTime();
        timeLinked = end - start;

        System.out.println("LinkedList Time Adding (Nanoseconds): " + timeLinked);

        if (timeArray<timeLinked) {
            System.out.println("ArrayList is better");
        } else {
            System.out.println("LinkedList is better");
        }

        System.out.println("--------------------------------------------- ");

        start = System.nanoTime();

        arrayList.remove((sizeArray-1)/2);

        end = System.nanoTime();
        timeArray = end - start;

        System.out.println("ArrayList Time Removing (Nanoseconds): " + timeArray);

        start = System.nanoTime();

        linkedList.remove((sizeLinked-1)/2);

        end = System.nanoTime();
        timeLinked = end - start;

        System.out.println("LinkedList Time Removing (Nanoseconds): " + timeLinked);

        if (timeArray<timeLinked) {
            System.out.println("ArrayList is better");
        } else {
            System.out.println("LinkedList is better");
        }
        System.out.println("--------------------------------------------- ");

        start = System.nanoTime();

        arrayList.add((sizeArray-1)/2, 69);

        end = System.nanoTime();
        timeArray = end - start;

        System.out.println("ArrayList Time Adding In The Middle (Nanoseconds): " + timeArray);

        start = System.nanoTime();

        linkedList.add((sizeLinked-1)/2, 69);

        end = System.nanoTime();
        timeLinked = end - start;

        System.out.println("LinkedList Time Adding In The Middle (Nanoseconds): " + timeLinked);

        if (timeArray<timeLinked) {
            System.out.println("ArrayList is better");
        } else {
            System.out.println("LinkedList is better");
        }
        System.out.println("--------------------------------------------- ");
        
        start = System.nanoTime();

        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }

        end = System.nanoTime();
        timeArray = end - start;

        System.out.println("ArrayList Time Iterating (Nanoseconds): " + timeArray);

        start = System.nanoTime();

        for (Integer a : linkedList) {
            
        }

        end = System.nanoTime();
        timeLinked = end - start;

        System.out.println("LinkedList Time Adding Iterating (Nanoseconds): " + timeLinked);

        if (timeArray<timeLinked) {
            System.out.println("ArrayList is better");
        } else {
            System.out.println("LinkedList is better");
        }
        System.out.println("--------------------------------------------- ");

        start = System.nanoTime();

        Collections.sort(arrayList);

        end = System.nanoTime();
        timeArray = end - start;

        System.out.println("ArrayList Time Sorting (Nanoseconds): " + timeArray);

        start = System.nanoTime();

        Collections.sort(linkedList);

        end = System.nanoTime();
        timeLinked = end - start;

        System.out.println("LinkedList Time Sorting (Nanoseconds): " + timeLinked);

        if (timeArray<timeLinked) {
            System.out.println("ArrayList is better");
        } else {
            System.out.println("LinkedList is better");
        }
    }

    private static List<Integer> populate(List<Integer> objects, int amount) {
        return new Random()
                .ints()
                .limit(amount)
                .boxed()
                .collect(Collectors.toCollection(() -> objects));
    }
}