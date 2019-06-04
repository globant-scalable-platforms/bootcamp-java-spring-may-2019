import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class Data {
    protected ArrayList arrlist = new ArrayList();
    protected LinkedList linkList = new LinkedList();
    protected HashMap hashMap = new HashMap();
    protected TreeMap treeMap = new TreeMap();
    protected String fileContent = "Start,end,total time,structure,n of values";
    protected long start;
    protected long end;
    protected BufferedWriter writer;

    protected void function(int a, ArrayList l, int reps) throws IOException {
    }

    protected void function(int a, LinkedList l, int reps) throws IOException {
    }

    protected void function(int a, HashMap map, int reps) throws IOException {
    }
    protected void function(int a, TreeMap treeMap, int reps) throws IOException {
    }

}
