# Kata_Collection

in the path collections\src\main\java there are the following classes to resolve the collections katas:
- ArrayListVSLinkedList.java
- HashMapVSTreeMap.java
- ComparisonUtils.java
- RansomNote.java

Comparison Findings

In these cases, we can see that ArrayList is faster than LinkedList in almost all operations except in the addition operation.

ArrayList vs LinkedList --> 100000 elements

Adding sequentially values
ArrayList --> Time (Miliseconds): 5.838396
LinkedList --> Time (Miliseconds): 3.245643
Adding random values
ArrayList --> Time (Miliseconds): 3.368755
LinkedList --> Time (Miliseconds): 3.078929
Removing an element from middle
ArrayList --> Time (Miliseconds): 911.116861
LinkedList --> Time (Miliseconds): 3077.794263
Adding element in the middle
ArrayList --> Time (Miliseconds): 465.313313
LinkedList --> Time (Miliseconds): 5245.554874
Iterating elements
ArrayList --> Time (Miliseconds): 2.471351
LinkedList --> Time (Miliseconds): 6.747198
Sorting elements
ArrayList --> Time (Miliseconds): 5.18807
LinkedList --> Time (Miliseconds): 7.734656

In maps, TreeMap has a lower performance than HashMap, it is only better when it is add values ​​sequentially.

HashMap vs TreeMap --> 1000000 elements

Adding sequentially values
HashMap --> Time (Miliseconds): 1399.73816
TreeMap --> Time (Miliseconds): 253.576791
Adding random values
HashMap --> Time (Miliseconds): 351.988537
TreeMap --> Time (Miliseconds): 323.844433
Finding elements by key
HashMap --> Time (Miliseconds): 22.123322
TreeMap --> Time (Miliseconds): 72.505024
Removing elements by key
HashMap --> Time (Miliseconds): 30.610896
TreeMap --> Time (Miliseconds): 154.139684
Iterating entries
HashMap --> Time (Miliseconds): 17.742886
TreeMap --> Time (Miliseconds): 30.505453


