/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.challenge1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author USUARIO
 */
public class CollectionsArrayVSLinked {
    
    public static int LIMIT = 10000000;

    private ArrayList<Integer> containerArray = new ArrayList();
    private LinkedList<Integer> containerLinked = new LinkedList();
    
    public void addElement(int element, List container) {
        container.add(element);
    }

    public void insertInMiddle(int element, List container) {
        int middle = container.size() / 2;
        container.add(middle, element);
    }

    public void removeFromMiddle(List container) {
        int middle = container.size() / 2;
        container.remove(middle);
    }

    public void orderContainer(List container) {
        container.sort(Comparator.naturalOrder());
    }

    public void showContainer(List container) {
        container.forEach(value -> System.out.print(value + " "));
    }

    public void initContainer(List container) {
        for (int i = 0; i < LIMIT; i++) {
            container.add(new Random().nextInt(LIMIT*2));
        }
    }

    public ArrayList<Integer> getContainerArray() {
        return containerArray;
    }

    public void setContainerArray(ArrayList<Integer> containerArray) {
        this.containerArray = containerArray;
    }

    public LinkedList<Integer> getContainerLinked() {
        return containerLinked;
    }

    public void setContainerLinked(LinkedList<Integer> containerLinked) {
        this.containerLinked = containerLinked;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CollectionsArrayVSLinked collections = new CollectionsArrayVSLinked();
        Random r = new Random();
        
        long start,end;        

        collections.initContainer(collections.getContainerArray());
        collections.initContainer(collections.getContainerLinked());

        System.out.println("Add new Element...\n");
        start = System.nanoTime();
        collections.addElement(r.nextInt(LIMIT), collections.getContainerArray());
        end = System.nanoTime();        
        System.out.println("Time (Miliseconds) ArrayList: " + ((end - start)/1000000));
        
        start = System.nanoTime();
        collections.addElement(r.nextInt(LIMIT), collections.getContainerLinked());
        end = System.nanoTime();        
        System.out.println("Time (Miliseconds) Linked: " + ((end - start)/1000000));
        
        
        System.out.println("\nRemove element from the middle...\n");
        start = System.nanoTime();
        collections.removeFromMiddle(collections.getContainerArray());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) ArrayList: " + ((end - start)/1000000));        
        
        start = System.nanoTime();
        collections.removeFromMiddle(collections.getContainerLinked());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) Linked: " + ((end - start)/1000000));
        
        System.out.println("\nInsert in the middle...\n");
        start = System.nanoTime();
        collections.insertInMiddle(r.nextInt(LIMIT), collections.getContainerArray());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) ArrayList: " + ((end - start)/1000000));        
        start = System.nanoTime();
        collections.insertInMiddle(r.nextInt(LIMIT), collections.getContainerLinked());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) Linked: " + ((end - start)/1000000));
        
        System.out.println("\nIterate over the whole collection...\n");
        start = System.nanoTime();
        collections.showContainer(collections.getContainerArray());
        end = System.nanoTime();
        System.out.println("\nTime (Miliseconds) ArrayList: " + ((end - start)/1000000));        
        start = System.nanoTime();
        collections.showContainer(collections.getContainerLinked());
        end = System.nanoTime();
        System.out.println("\nTime (Miliseconds) Linked: " + ((end - start)/1000000));
        
        System.out.println("\nSorting the collection...\n");
        
        start = System.nanoTime();
        collections.orderContainer(collections.getContainerArray()); 
        end = System.nanoTime();
        System.out.println("\nTime (Miliseconds) ArrayList: " + ((end - start)/1000000));                
        start = System.nanoTime();               
        collections.orderContainer(collections.getContainerLinked());
        end = System.nanoTime();
        System.out.println("\nTime (Miliseconds) Linked: " + ((end - start)/1000000));
        
        
        
        

    }

}
