# HashMap vs. TreeMap

## Putting elements in the maps

For this experiment 1.000.000 strings were generated randomly to be used as keys to be inserted in the map, using the UUID class. These are results: 

| Run  | ArrayList | LinkedList |
| :--: | :-------: | :--------: |
| 0    |233.02227|1359.720042|
| 1    |232.838966|1546.420989|
| 2    |240.65929|1298.926637|
| 3    |237.220222|1380.671548|
| 4    |252.799506|1330.059242|
| 5    |229.941141|1232.499305|
| 6    |232.917068|1226.829087|
| 7    |233.842765|1319.164115|
| 8    |221.914413|1253.539454|
| 9    |239.961195|1311.641556|

The times are considerably greater when inserting in the TreeMap, the main reason for this, is that a TreeMap is backed by a Binary Search Tree, which in case of being balanced will require O(log n) to insert an element. 

## Find element by key

Similarly to the last experiment, 1.000.000 strings were generated randomly to be used as keys to be inserted in the map, afterwards a _get_ operation with these keys was performed, in order to know the runtime of retrieving the elements. These are the results:

| Run  | ArrayList | LinkedList |
| :--: | :-------: | :--------: |
| 0    |66.300514|1173.965755|
| 1    |32.447116|1175.272319|
| 2    |31.808876|1201.147338|
| 3    |31.243729|1206.274731|
| 4    |32.20963|1132.329254|
| 5    |32.310139|1143.996444|
| 6    |33.061585|1228.355573|
| 7    |33.409789|1014.559313|
| 8    |33.696515|1279.519469|
| 9    |31.764064|1154.823406|

As it was mentioned before a TreeMap is backed by a Binary Search Tree, searching an element requires O(log n), where _n_ is the amount of elements in the tree. On the other hand, according to the Java Documentation the HashMap _get_ function is constant in time. 

## Remove elements by key

For this experiment 1.000.000 keys were generated and introduced in the map. Afterwards all the elements in the maps were removed using the keys. These are the results:

| Run  | ArrayList | LinkedList |
| :--: | :-------: | :--------: |
| 0    |60.149098|1136.488547|
| 1    |44.960658|1160.109012|
| 2    |49.539651|1194.807576|
| 3    |68.288028|1330.814803|
| 4    |47.335039|1167.524894|
| 5    |59.836407|1238.413408|
| 6    |51.042851|1327.618401|
| 7    |56.584104|1037.606952|
| 8    |43.861816|1177.501573|
| 9    |55.014767|1238.421147|

As in the previous experiments, the fact that the TreeMap is backed by a BinarySearchTree makes the runtime more expensive. In this case, everytime a deletion has to be made, it is required to find the node, delete it and balance the tree, which ends up being an expensive operation to perform. 