import java.util.*;

public class ChallengeMain {
    public static void main(String[]args) {
        Integer[] array = generateRandomArray(10000000);

        List<Integer> arrayList = new ArrayList<>(Arrays.asList(array.clone()));
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(array.clone()));

        Random random = new Random();

        // Adding a new element
        System.out.println(" ------- Adding a new element -------- ");
        Date arrayTimestamp = new Date();
        arrayList.add(random.nextInt());
        System.out.println("ArrayList inserting time: " + (new Date().getTime() - arrayTimestamp.getTime()));

        Date linkedTimestamp = new Date();
        linkedList.add(random.nextInt());
        System.out.println("LinkedList inserting time: " + (new Date().getTime() - linkedTimestamp.getTime()));

        // Remove an element from the middle
        System.out.println(" ------- Remove an element from the middle -------- ");
        arrayTimestamp = new Date();
        arrayList.remove(500000);
        System.out.println("ArrayList removing in the middle time: " + (new Date().getTime() - arrayTimestamp.getTime()));

        linkedTimestamp = new Date();
        linkedList.remove(500000);
        System.out.println("LinkedList removing in the middle time: " + (new Date().getTime() - linkedTimestamp.getTime()));

        // Insert in the middle a new element
        System.out.println(" ------- Insert in the middle a new element -------- ");
        arrayTimestamp = new Date();
        arrayList.add(500000, random.nextInt());
        System.out.println("ArrayList inserting in the middle time: " + (new Date().getTime() - arrayTimestamp.getTime()));

        linkedTimestamp = new Date();
        linkedList.add(500000, random.nextInt());
        System.out.println("LinkedList inserting in the middle time: " + (new Date().getTime() - linkedTimestamp.getTime()));

        // Iterate over the whole collection
        System.out.println(" ------- Iterate over the whole collection -------- ");
        arrayTimestamp = new Date();
        arrayList.forEach(a -> a = a + 1);
        System.out.println("ArrayList iteration time: " + (new Date().getTime() - arrayTimestamp.getTime()));

        linkedTimestamp = new Date();
        linkedList.forEach(a -> a = a + 1);
        System.out.println("LinkedList iteration time: " + (new Date().getTime() - linkedTimestamp.getTime()));

        // Sorting the collection
        System.out.println(" ------- Sorting the collection -------- ");
        arrayTimestamp = new Date();
        arrayList.sort(Collections.reverseOrder());
        System.out.println("ArrayList sorting time: " + (new Date().getTime() - arrayTimestamp.getTime()));

        linkedTimestamp = new Date();
        linkedList.forEach(a -> a = a + 1);
        System.out.println("LinkedList sorting time: " + (new Date().getTime() - linkedTimestamp.getTime()));
    }

    private static Integer[] generateRandomArray(int numElements) {
        Random random = new Random();
        Integer[] integerArray = new Integer[numElements];

        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = random.nextInt();
        }

        return integerArray;
    }
}

