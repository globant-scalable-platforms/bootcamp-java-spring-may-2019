import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        AddData addData = new AddData();
        InsertData insertData = new InsertData();
        RemoveData removeData = new RemoveData();
        try {
            addData.function(100000, addData.arrlist, 10);
            addData.function(100000, addData.linkList, 10);
            addData.function(100000, addData.hashMap,10);
            addData.function(100000,addData.treeMap,10);
            insertData.function(100000, insertData.arrlist,10);
            insertData.function(100000,insertData.linkList,10);
            insertData.function(100000,insertData.hashMap,10);
            insertData.function(100000,insertData.treeMap,10);
            removeData.function(100000,removeData.arrlist,10);
            removeData.function(100000,removeData.linkList,10);
            removeData.function(100000,removeData.hashMap,10);
            removeData.function(10000,removeData.treeMap,10);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        System.out.println(" fin");
    }
}
