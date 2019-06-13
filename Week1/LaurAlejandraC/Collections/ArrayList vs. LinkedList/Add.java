import java.util.*;

class Add{
    private static final int runs = 10;
    private static final boolean middle = false;

    public static void main(String[] args){
        Double[] resultArrayList = new Double[runs];
        Double[] resultLinkedList = new Double[runs];

        Long start, end;

        for(int i = 0; i < runs; i++){
            Integer[] toFill = new Integer[10000000];
            fillWithRandom(toFill);

            // Add elements to ArrayList

            ArrayList<Integer> arrayList = new ArrayList<>();
            start = System.nanoTime();
            for(Integer cur : toFill){
                if(middle)
                    arrayList.add((int)(arrayList.size() / 2), cur);
                else
                    arrayList.add(cur);
            }
            end = System.nanoTime();

            resultArrayList[i] = (end - start) / 1000000.0;

            // Add elements to LinkedList
            LinkedList<Integer> linked = new LinkedList<>();
            start = System.nanoTime();
            for(Integer cur : toFill){
                if(middle)
                    linked.add((int)(linked.size() / 2), cur);
                else
                    linked.add(cur);
            }
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
