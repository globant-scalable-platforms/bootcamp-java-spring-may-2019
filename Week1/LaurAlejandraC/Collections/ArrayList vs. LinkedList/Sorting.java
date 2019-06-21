import java.util.*;

class Sorting{
    private static final int runs = 10;

    public static void main(String[] args){
        Double[] resultArrayList = new Double[runs];
        Double[] resultLinkedList = new Double[runs];

        Long start, end;

        for(int i = 0; i < runs; i++){
            Integer[] toFill = new Integer[10000000];
            fillWithRandom(toFill);

            ArrayList<Integer> array = new ArrayList<>(Arrays.asList(toFill));

            start = System.nanoTime();
            Collections.sort(array);
            end = System.nanoTime();

            resultArrayList[i] = (end - start) / 1000000.0;

            LinkedList<Integer> linked = new LinkedList<>(Arrays.asList(toFill));

            start = System.nanoTime();
            Collections.sort(linked);
            end = System.nanoTime();

            resultLinkedList[i] = (end - start) / 1000000.0;

            System.out.println("| " + i + "    |" + resultArrayList[i] + "|" + resultLinkedList[i] + "|");
        }
    }

    public static void fillWithRandom(Integer[] array){
        Random rand = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = rand.nextInt();
        }
    }
}