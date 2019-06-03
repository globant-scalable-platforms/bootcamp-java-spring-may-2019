# Collection challenges

It were using 10000000 elements inserted way random

##### Lists

Add an element can have the same time(Miliseconds), because de insert ocurrs at the end of the list.

Remove an element in the middle takes more time in the LinkedList

Insert an element in the middle takes more time in the LinkedList

Iterate the collection takes more time in the LinkedList

Sort the collection takes more time in the LinkedList

In general terms the ArrayList is more efficient than LinkedList in several aspects, surely because the LinkedList uses references for the back and next element, so reorganize the elements can cost more time.

Results:

| Test | Arraylist | Linkedlist
| ------ | ------ | ------ |
| Add an element | < 1ms | < 1ms |
| Remove an element from the middle | 13ms | 128ms |
| Insert an element in the middle | 12ms | 127ms |
| Iterate | 397098ms | 521449ms |
| Sort | 19757ms | 25682ms |

##### Map

The process for find,put, and remove an element by key, is notably efficient in both types of Map.

In the process to iterate the maps, takes more time than the collections.
In the Treemaps' case the iteration takes more time because the elements are sorted according to natural order of keys.

Results:

| Test | Hashmap | Treemap
| ------ | ------ | ------ |
| Put an element | < 1ms | < 1ms |
| Find by key | < 1ms | < 1ms |
| Remove by key | < 1ms | < 1ms |
| Iterate | 874276ms | 978155ms |