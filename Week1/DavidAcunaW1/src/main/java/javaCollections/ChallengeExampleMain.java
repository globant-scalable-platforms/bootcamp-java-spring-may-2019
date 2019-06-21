package javaCollections;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChallengeExampleMain {
    public static void main(String[] args){
    	System.out.println("--- ArrayList vs LinkedList	 ---");

        List<Integer> list = populate(new ArrayList<Integer>(), 10000000);
        
        Add.add(list); 
        Sort.sort(list);
        RemoveFromMiddle.remove(list);
        AddInMiddle.add(list);
        IterateCol.iterate(list);
        
        LinkedList<Integer> linkedList = populateLinkedList(new LinkedList<Integer>(), 10000000);                 
          
        Add.addLinked(linkedList);       
        Sort.sortLinked(linkedList);
        RemoveFromMiddle.removeLinked(linkedList);
        AddInMiddle.addLinked(linkedList);        
        IterateCol.iterateLinked(linkedList);
        
        System.out.println("--- HashMap vs TreeMap ---");
        
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0,1000000).forEach(i -> map.put(i,i));
        
        MapPut.put(map);
        MapFind.find(map);
        MapRemove.remove(map);
        MapIterate.iterate(map);
        
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        IntStream.range(0,1000000).forEach(i -> treeMap.put(i,i));
            
        MapPut.putTree(treeMap);
        MapFind.findtTree(treeMap);
        MapRemove.removeTree(treeMap);
        MapIterate.iterateTree(treeMap);
    }

    private static List<Integer> populate(ArrayList<Integer> objects, int amount) {
        return new Random()
                .ints()
                .limit(amount)
                .boxed()
                .collect(Collectors.toCollection(() -> objects));
    }
    
    private static LinkedList<Integer> populateLinkedList(LinkedList<Integer> objects, int amount) {
        return new Random()
                .ints()
                .limit(amount)
                .boxed()
                .collect(Collectors.toCollection(() -> objects));
    }
}
