import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class AddData extends Data {

    @Override
    public void function(int a, ArrayList l, int reps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("addArrayList.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {
            start = System.currentTimeMillis();
            for (int i = 0; i < a * j; i++) {
                arrlist.add(i);
            }
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",ArrayList," + (a * j);
            writer.write(fileContent);

            writer.newLine();
        }
        writer.close();

    }

    @Override
    public void function(int a, LinkedList l, int reps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("addLinkedList.txt"));
        writer.write(fileContent);
        writer.newLine();


        for (int j = 1; j <= reps; j++) {
            start = System.currentTimeMillis();
            for (int i = 0; i < a * j; i++) {
                linkList.add(i);
            }
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",LinkedList," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }

        writer.close();

    }

    @Override
    protected void function(int a, HashMap map, int reps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("addHashMap.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {
            start = System.currentTimeMillis();
            for (int i = 0; i < a * j; i++) {
                map.put(i,i);
            }
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",HashMap," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }

    @Override
    protected void function(int a, TreeMap treeMap, int reps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("addTreeMap.txt"));
        writer.write(fileContent);
        writer.newLine();

        for (int j = 1; j <= reps; j++) {
            start = System.currentTimeMillis();
            for (int i = 0; i < a * j; i++) {
                treeMap.put(i,i);
            }
            end = System.currentTimeMillis();
            fileContent = start + "," + end + "," + (end - start) + ",TreeMap," + (a * j);
            writer.write(fileContent);
            writer.newLine();
        }
        writer.close();
    }
}
