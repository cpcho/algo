Heap
/*
Parent		Child
   n         2n+1
	         2n+2

How to find the parent of index n:
	floor(n-1/2) 
	round down to the nearst integer

Can be implemented in priority queue efficiently.
Insert(), delete(), extractmax(), decreaseKey() operated in O(log n).

Can solve the following problems:
https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
https://www.geeksforgeeks.org/nearly-sorted-algorithm/
https://www.geeksforgeeks.org/merge-k-sorted-arrays/

Difference between priority queue and heap:

A priority queue is an abstract datatype. It is a shorthand way of describing a particular interface and behavior, and says nothing about the underlying implementation.

A heap is a data structure. It is a name for a particular way of storing data that makes certain operations very efficient.

It just so happens that a heap is a very good data structure to implement a priority queue, because the operations which are made efficient by the 
heap data strucure are the operations that the priority queue interface needs.*/

