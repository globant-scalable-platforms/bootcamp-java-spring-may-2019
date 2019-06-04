import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class RemoveData extends Data{

    public void function(int a, ArrayList l, int reps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("removeArrayList.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {

            for (int i = 0; i < a * j; i++) {
                arrlist.add(i);
            }
            start = System.currentTimeMillis();
            arrlist.remove(a * j / 2);
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",ArrayList," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }

    public void function(int a, LinkedList l, int reps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("removeLinkedList.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {

            for (int i = 0; i < a * j; i++) {
                linkList.add(i);
            }
            start = System.currentTimeMillis();
            linkList.remove(a * j / 2);
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",LinkedList," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }

    @Override
    protected void function(int a, HashMap map, int reps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("removeHashMap.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {

            for (int i = 0; i < a * j; i++) {
                hashMap.put(i,i);
            }
            start = System.currentTimeMillis();
            hashMap.remove(a * j / 2);
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",HashMap," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }

    @Override
    protected void function(int a, TreeMap treeMap, int reps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("removeTreeMap.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {

            for (int i = 0; i < a * j; i++) {
                treeMap.put(i,i);
            }
            start = System.currentTimeMillis();
            treeMap.remove(a * j / 2);
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",TreeMap," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }
}
