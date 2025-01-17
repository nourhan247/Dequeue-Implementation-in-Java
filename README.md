# Dequeue-Implementation-in-Java

This repository contains an implementation of a Dequeue (Double-Ended Queue) in Java. A dequeue is a data structure that allows elements to be added or removed from both ends, making it a versatile tool for solving a variety of problems.

Features
Double-Ended Operations:
Add elements at the front (enqueueFront) or rear (enqueueRear).
Remove elements from the front (dequeueFront) or rear (dequeueRear).
Circular Array Implementation:
Efficiently utilizes a fixed-size array with wrap-around behavior for front and rear pointers.
Utility Methods:
isFull: Checks if the queue is full.
isEmpty: Checks if the queue is empty.
getFront: Retrieves the element at the front.
getRear: Retrieves the element at the rear.
display: Prints the current elements in the queue.
Time Complexity
Enqueue and Dequeue Operations: 𝑂(1)
Utility Methods (isFull, isEmpty, getFront, getRear): O(1)
Display Method: O(n) (where 𝑛
is the number of elements in the queue).
How It Works
Initialization:

A fixed-size array is used to implement the queue.
The front and rear pointers track the ends of the queue.
Wrap-around behavior is achieved using modulo arithmetic.
Edge Cases Handled:

Overflow: Attempting to enqueue when the queue is full.
Underflow: Attempting to dequeue when the queue is empty.
Circular Behavior: Ensures that elements can be added and removed even after wrapping around the end of the array.
Applications:

Implementing cache systems.
Handling sliding window problems.
Real-world scheduling systems (e.g., task queues).
