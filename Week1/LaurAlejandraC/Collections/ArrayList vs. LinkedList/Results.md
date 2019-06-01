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

## Removing elements

To compare the performance of the deletion of elements of both data structures, 500.000 randomly generated elements were introduced and then the removal was done by deleting the middle element, until it was empty. These are the results:

| Run  | ArrayList | LinkedList |
| :--: | :-------: | :--------: |
| 0    |12763.167444|97244.856447|
| 1    |12571.672897|100134.848039|
| 2    |12581.522105|98712.65971|
| 3    |13226.581317|112992.199553|
| 4    |12864.544077|110101.183312|
| 5    |13090.433258|113987.816915|
| 6    |12421.614214|100072.559212|
| 7    |13440.618999|105630.724197|
| 8    |13090.94765|107265.611273|
| 9    |12851.404415|103888.869027|

The results are similar than when adding in the middle position, seen on the previous experiment, due to the same reasons. The times for both are smaller compared to the addition, this has to do with the allocation of memory that is required for both data structures when adding.

## Iterate over the whole collection

For this experiment the ArrayList and LinkedList iterators were used. The experiment was realized for 10.000.000 randomly generated elements. These are the results:

| Run  | ArrayList | LinkedList |
| :--: | :-------: | :--------: |
| 0    |13.803908|34.989844|
| 1    |39.910735|29.5185|
| 2    |0.393933|30.883106|
| 3    |0.352124|24.789555|
| 4    |0.364093|28.792904|
| 5    |0.503611|27.505166|
| 6    |0.364829|29.474882|
| 7    |0.352032|33.227527|
| 8    |0.385448|28.920211|
| 9    |0.363719|26.875483|

In general, for collections with sequential access, such as a LinkedList, tend to perform slower than the random access ones, as an ArrayList. 
Another reason, is that in general is it faster due to the fact that in the back, the ArrayList is implemented using an array.

## Sorting

The sorting was performed for 10.000.000 randomly generated numbers. The sorting was done using the function provided by the Collections Class, in which a MergeSort is performed using the natural ordering. These are the results:

| Run  | ArrayList | LinkedList |
| :--: | :-------: | :--------: |
| 0    |6531.269205|4902.722325|
| 1    |4706.457528|4921.242176|
| 2    |5189.606816|5469.631491|
| 3    |4949.03243|5341.894295|
| 4    |4626.303267|5577.713467|
| 5    |4614.749448|5475.884259|
| 6    |4624.72914|6516.983407|
| 7    |7137.413275|7271.115957|
| 8    |6230.675212|6103.458672|
| 9    |4739.822583|6032.630484|

In most of the runs, the performance was slightly better in the ArrayList.