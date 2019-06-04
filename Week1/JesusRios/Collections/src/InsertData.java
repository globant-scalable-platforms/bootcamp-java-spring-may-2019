import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class InsertData extends Data {

    @Override
    public void function(int a, ArrayList l, int reps) throws IOException {
        writer = new BufferedWriter(new FileWriter("insertArrayList.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {

            for (int i = 0; i < a * j; i++) {
                arrlist.add(i);
            }
            start = System.currentTimeMillis();
            arrlist.add(a * j / 2, 1000);
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",ArrayList," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }

        writer.close();

    }

    @Override
    public void function(int a, LinkedList l, int reps) throws IOException {
        writer = new BufferedWriter(new FileWriter("insertLinkedList.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {

            for (int i = 0; i < a * j; i++) {
                linkList.add(i);
            }
            start = System.currentTimeMillis();
            linkList.add(a * j / 2, 10000);
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",LinkedList," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }

    @Override
    public void function(int a, HashMap map, int reps) throws IOException {
        writer = new BufferedWriter(new FileWriter("findHashMap.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {

            for (int i = 0; i < a * j; i++) {
                hashMap.put(i, i);
            }
            start = System.currentTimeMillis();
            hashMap.get(a * j / 2);
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",HashMap," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }
    @Override
    public void function(int a, TreeMap treeMap, int reps) throws IOException {
        writer = new BufferedWriter(new FileWriter("findTreeMaop.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {

            for (int i = 0; i < a * j; i++) {
                treeMap.put(i, i);
            }
            start = System.currentTimeMillis();
            treeMap.get(a * j / 2);
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",TreeMap," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }
}
