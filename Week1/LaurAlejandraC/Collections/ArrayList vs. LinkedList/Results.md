# Results ArrayList vs. LinkedList

## Adding elements

### Add at the end
The first approach is to add the elements at the end of the lists, the same elements are added to both data structures, in this example 10.000.000 randomly generated elements were added. These are the resulting times for ten runs in miliseconds:

| Run  | ArrayList | LinkedList |
| :--: | :-------: | :--------: |
| 0    |344.03257  |4007.465942 |
| 1    |684.084971 |3531.81662  |
| 2    |72.713985  |232.126614  |
| 3    |240.489206 |354.831664  |
| 4    |3530.59848 |288.337967  |
| 5    |72.788624  |2604.650932 |
| 6    |472.089053 |2857.409738 |
| 7    |71.139735  |354.494289  |
| 8    |241.024642 |2773.474683 |
| 9    |483.285565 |360.502294  |

In most of the runs the time of the ArrayList addition was smaller than the one from the LinkedList. It is important to notice that accordingly to the Java Documentation, both Data Structures run addition in constant time. 

### Add at the middle

I think it is also interesting to see the behavior of adding an element in the middle position. These are the results for 500.000 randomly generated elements:

| Run  | ArrayList | LinkedList |
| :--: | :-------: | :--------: |
| 0    |13113.542649|188612.424946|
| 1    |13980.878215|184161.522092|
| 2    |13550.085545|181383.824898|
| 3    |13344.302702|183722.916469|
| 4    |12998.337076|183532.806399|
| 5    |12876.669108|169627.921677|
| 6    |12878.825669|169942.370694|
| 7    |12882.891902|167183.621252|
| 8    |12884.079591|166500.013396|
| 9    |12852.429701|168900.878367|

As it can be seen, the performance of the ArrayList is much better compared to the LinkedList. Even though the ArrayList has to copy the array in order to "open a space" for the new element, it remains faster since the LinkedList needs to iterate from the head node of the LinkedList until the i-th element, in order to insert the new element. As well it is cheaper to handle with an ArrayList since all the data is alligned in memory, on the other hand the LinkedList needs to handle Java Object references for every single element, which can lead to an expesive performance.