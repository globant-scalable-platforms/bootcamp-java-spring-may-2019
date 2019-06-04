# Collections challenge

Versus challenge between some data structures of Java.

Some of the results are not consistent with the theory, probably because of the nature of the elements or the processing environment.

Tested with 10000000 of elements.

## ArrayList VS. LinkedList

### RESULTS:

Add a new element.

In the theory, Add operation should be faster in LinkedList as compared to ArrayList because there is no risk of resizing.

```bash
ArrayList add (Miliseconds): 1953  VS.  LinkedList add (Miliseconds): 8684
```

Remove an element from the middle.

In the theory LinkedList should be faster than ArrayList because ArrayList needs to update its index for a remove operation if it is not at the end of the array.

```bash
ArrayList remove (Miliseconds): 2  VS.  Time LinkedList remove (Miliseconds): 39
```

Insert in the middle a new element.

LinkedList should be faster for the same reasons of the Remove operation.


```bash
ArrayList insert (Miliseconds): 2  VS.  LinkedList insert (Miliseconds): 38
```

Iterate over the whole collection.

Both are O(n) time complexity, but the ArrayList implementation have a better result.

```bash
ArrayList iterate (Miliseconds): 35  VS.  LinkedList iterate (Miliseconds): 102
```

Sorting the collection.

ArrayList is definitely more efficient than LinkedList.

```bash
ArrayList sort (Miliseconds): 36  VS.  LinkedList sort (Miliseconds): 272
```

## HasMap VS. TreeMap

### RESULTS:

HasMap have the best performance for most operations like put and iterate the whole entries.
Find and remove are very similir because both implementations access directely the element given the key withput an iterator.

Put a new element.

```bash
 HashMap put (Miliseconds): 4721  VS.  TreeMap put (Miliseconds): 7712
```

Find an element by key.

```bash
 HashMap find (Miliseconds): 0  VS.  TreeMap find (Miliseconds): 0
```

Remove an element by key.

```bash
 HashMap remove (Miliseconds): 0  VS.  TreeMap remove (Miliseconds): 0
```

Iterate over the whole entries.

```bash
 HashMap iterate (Miliseconds): 84  VS.  TreeMap iterate (Miliseconds): 149
```