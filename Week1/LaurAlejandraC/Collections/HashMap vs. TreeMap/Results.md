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

