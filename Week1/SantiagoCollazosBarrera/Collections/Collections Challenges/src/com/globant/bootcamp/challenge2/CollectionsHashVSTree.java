/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.challenge2;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 *
 * @author USUARIO
 */
public class CollectionsHashVSTree {

    public static int LIMIT = 10000000;
    
    private int keyReserved;

    private HashMap<Integer, Integer> hash = new HashMap();
    private TreeMap<Integer, Integer> tree = new TreeMap();

    public void putElement(Integer key, Integer value, Map map) {
        map.put(key, value);
    }

    public Integer findElement(Integer key, Map map) {
        return (Integer) map.get(key);
    }

    public void removeElement(Integer key, Map map) {
        map.remove(key);
    }

    public void initMap() {
        Random r = new Random();
        int key = 0,value = 0;
        for (int i = 0; i < LIMIT; i++) {
            key = r.nextInt(LIMIT);
            if (!hash.containsKey(key)) {
                value = new Random().nextInt(LIMIT);
                hash.put(key, value);
                tree.put(key, value);
            }
        }
        keyReserved = key;
    }

    public void showMap(Map map) {
        map.forEach((k, v) -> {
            System.out.print(" Key:" + k + " Value:" + v);
        });
    }

    public HashMap<Integer, Integer> getHash() {
        return hash;
    }

    public void setHash(HashMap<Integer, Integer> hash) {
        this.hash = hash;
    }

    public TreeMap<Integer, Integer> getTree() {
        return tree;
    }

    public void setTree(TreeMap<Integer, Integer> tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {
        CollectionsHashVSTree collections = new CollectionsHashVSTree();
        Random r = new Random();
        long start, end;

        collections.initMap();

        //collections.showMap(collections.getHash());
        //collections.showMap(collections.getTree());

        System.out.println("\nPut new Element...\n");
        start = System.nanoTime();
        collections.putElement(r.nextInt(LIMIT), r.nextInt(LIMIT), collections.getHash());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) HashMap: " + ((end - start) / 1000000));

        start = System.nanoTime();
        collections.putElement(r.nextInt(LIMIT), r.nextInt(LIMIT), collections.getTree());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) TreeMap: " + ((end - start) / 1000000));

        //--------
        System.out.println("\nFind Element...\n");
        start = System.nanoTime();
        collections.findElement(collections.keyReserved, collections.getHash());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) HashMap: " + ((end - start) / 1000000));

        start = System.nanoTime();
        collections.findElement(collections.keyReserved, collections.getTree());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) TreeMap: " + ((end - start) / 1000000));

        //-------------
        System.out.println("\nRemove Element...\n");
        start = System.nanoTime();
        collections.removeElement(collections.keyReserved, collections.getHash());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) HashMap: " + ((end - start) / 1000000));

        start = System.nanoTime();
        collections.removeElement(collections.keyReserved, collections.getTree());
        end = System.nanoTime();
        System.out.println("Time (Miliseconds) TreeMap: " + ((end - start) / 1000000));

        //--------------
        System.out.println("\nIterate...\n");
        start = System.nanoTime();
        collections.showMap(collections.getHash());
        end = System.nanoTime();
        System.out.println("\nTime (Miliseconds) HashMap: " + ((end - start) / 1000000));

        start = System.nanoTime();
        collections.showMap(collections.getTree());
        end = System.nanoTime();
        System.out.println("\nTime (Miliseconds) TreeMap: " + ((end - start) / 1000000));

    }

}
