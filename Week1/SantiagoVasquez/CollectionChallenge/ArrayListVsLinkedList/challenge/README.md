### ArrayList vs LinkedList

The following times are in milliseconds.

Predicate: 
 - ArrayList implementation is based on in-memory array.
 - LinkedList implementation is based on pointers classes concatenated.


 ------- Adding a new element -------- 

ArrayList inserting time: 52

LinkedList inserting time: 0

Conclusion: Adding in an ArrayList means that it have to create space in memory if 
there is not available. Meanwhile, adding in a LinkedList is "easier" because it 
doesnt care where is the object in memory, it only has to link it by a pointer.

 ------- Remove an element from the middle -------- 

ArrayList removing in the middle time: 4

LinkedList removing in the middle time: 20

Conclusion: Knowing where the element is placed is crucial in this test. ArrayList
knows exactly the positions of every element. Otherwise, LinkedList has to "iterate" 
until find the element or use something to find the element quicker like checkpoints.
ArrayList could need to create a new space in memory or reallocating some fragments 
for whole collection, but this operation could be quicker than "finding" 
the element in the collection.

 ------- Insert in the middle a new element -------- 

ArrayList inserting in the middle time: 3

LinkedList inserting in the middle time: 7

Conclusion: Similar as removing from the middle, ArrayList could find the position 
quicker than LinkedList but it has to create a new space in memory for whole 
collection. Meanwhile LinkedList only has to reorganize some pointers and voila!

 ------- Iterate over the whole collection -------- 

ArrayList iteration time: 266

LinkedList iteration time: 50

Conclusion: Iterate the whole collection in an ArrayList could be slower than a 
LinkedList because the collection could be in different spaces in memory.

 ------- Sorting the collection -------- 

ArrayList sorting time: 4476

LinkedList sorting time: 58

Conclusion: Re-arranging a whole collection for ArrayList could need to swap their 
element or create a new collection and place element by element. Otherwise, using 
a LinkedList needs to re-organize pointers, that is obviously quicker than swapping 
or create a new collection.
