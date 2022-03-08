Linked list is a data structure which is linear in nature and does not store the data in the sequential memory locations. A linked list consists of one or more nodes also called as links. 

Each link is a pair of two things one is the data part which holds the value of the element which needs to be stored in the linked list while the second part is the next which stores the address of the next link or node to which it points to. The starting node or link is known as the head. The last node has its next part pointing to the null as there is no further node to be pointed which marks the end of the linked list as shown in the below figure.

![image](https://user-images.githubusercontent.com/83352922/157174521-e6e0f70b-227b-4daa-98e9-282570d84616.png)

 
As shown above each node contains the data field and the reference field. A linked list can contain any number of nodes depending on the data which we need to store and the memory capacity that is available.
There are following types of linked list:

• Singly Linked List

• Doubly Linked List

• Circular Linked List

In doubly linked multiple links or nodes are connected to each other and each of the node contains three field in it namely prev, data, and next containing the pointer to previous node, the data of the element, and the pointer to next element respectively. The graphical representation of the doubly linked list is as shown below –

![image](https://user-images.githubusercontent.com/83352922/157174642-b65e3f63-6f36-4c71-9dd5-58c553f4101a.png)

A circular linked list is a data structure that helps to store the data in a linear way and is similar to the normal simple linked list but with functionality where the last element is connected to the first one. This facilitates the insertion of the new element in the linked list even when the linked list is full provided the first place of the linked list is empty.

The following figure shows the visual representation of the working of the circular queue and the way in which the data is stored in it.

![image](https://user-images.githubusercontent.com/83352922/157174683-c5348199-dbc8-4bca-b1cf-c6d776f324c7.png)

Dynamic memory allocation is used in linked list.

Processing each individual element in the linked list is called as traversal.

Difference between Array and Linked List

Linear Array	

• Difficult for insertion and deletion.

• Space is wasted as fixed size needs to be specified priorly.

• Same amount of time is required for availing different elements stored in array.

• Elements are stored consecutively.

• Direct access to required node is done.


Linked List

• No movement of nodes required to perform insertion and deletion.

• No wastage of memory due to dynamic memory allocation.

• Different amount of time is required for availing different elements stored in array.

• Elements may not be stored consequently.

• Traversing of all the prior nodes needs to be done for reaching particular node.


Advantage

• No specification of the fixed size required as memory is allocated dynamically in runtime according to requirement.


Disadvantage

• Sequential access of the data needs to be done resulting in not able to use binary search which is why we cannot perform random access in linked list.

• More memory required for storing the pointer addresses.

• O(n) time complexity for accessing the element which results in slow performance due to recursion.

• Poor locality resulted due to scattered placement of data of the linked list.

Java.util package is used in Java Programming language for implementing the linked list.

Following are the interfaces implement linked list in java:

• Iterable

• List

• Queue

• Cloneable

• Deque

• Serializable

• Collection

Q. Why is merge sort a better option than quicksort for linked lists?

When it comes to linked lists, there are a few things to keep in mind. The issue is unique due to the memory allocation differences between arrays and linked lists. Unlike arrays, linked list nodes in memory may not be adjacent.
We can insert items in the middle of a linked list in O(1) extra space and O(1) time if we are given a reference/pointer to the previous node, unlike an array. As a result, the merge sort operation can be accomplished without the need for additional linked list space.
We can do random access in arrays since the elements are continuous in memory. In contrast to arrays, we can't access a linked list at random.
Quick Sort necessitates a great deal of this type of access. Because we don't have a continuous block of memory, we have to travel from the head to the i'th node to get to the i'th index in a linked list. Merge sort accesses data in a sequential manner, with less requirement for random access.
