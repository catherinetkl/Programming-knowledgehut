# Linked List
source: 
1. https://nlbsg.udemy.com/course/data-structures-and-algorithms-java/
2. https://blog.garybricks.com/a-beginners-overview-of-linked-lists-in-python
3. 

```java
public class LinkedList {
	public LinkedList(int value) {...}
	public void append(int value) {...} // append an item to the end of the linked list
	public Node removeLast() {...} // remove the last item
	public void prepend(int value) {...} // prepend an item
	public boolean insert(int index, int value) {...} // insert an item somewhere in the middle
	public Node remove(int index) {...} // remove an item
}
```

## What's a Linked List?
A dynamic data structure where each element(node) is made up of 2 items: data and a reference(pointer), which points to the next node.\
A linked list is a collection of nodes where each node is connected to the next through a pointer.\
Programmer has to go sequentially through each node until reaching the searched node.\
Elements can be stored anywhere in the memory.\
No need to specify length of linked list.\
An element has to point to the next or previous element.

## What's an Array?
A data structure comprising of a collection of elements each identified by the array index.\
Programmer can directly access an item in the array using the index. \
The elements are stored in contiguous memory locations.\
Programmer has to specify the size of the array when declaring the array.\
The elements are independent of each other.

## Differences between an array list and a linked list
1. Linked lists are dynamic in length, whereas array lists are fixed in length.
2. There are no indexes for linked lists to go directly to a particular item.
3. With a linked list, instead of all the items being in a contiguous place in memory, they are going to be spread out.
4. Linked list has a variable - Head that points to the first node, and tail that points to the last node.\
Both head and tail are pointers that just point to nodes. Each node is going to have pointer that points to the next node and so on.
Last node has a pointer, it just points to null (doesn't point to anything, it does have a variable there for that pointer.)
<div style="width:1399px; height:661px; background-color: #FFFFFF">
<img src="https://cdn.hashnode.com/res/hashnode/image/upload/v1637603328903/E1PjE0gz9.jpeg?auto=compress,format&format=webp" title="Understanding linked list">
</div>

## Big O
i) n - number of nodes, adding something to the end means O(1) <br>
ii) When a node is removed, in order to move tail pointer to point at the new last node, need to set the tail pointer to equal to the third node, which also points to the new last node. This means O(n) - one of the cases where array list is better than linked list<br>
iii) Adding an item to the head end of the linked list, the new first node have to point to the node with the head pointed to it, then set the pointer on the new first node to be equal to head. Then move the head pointer to point at the new node and that adds the new node into the list. This is also O(1). <br>
iv) insertion and removal of new node in between the linked list: O(n) <br>
v) look for something by value or index: O(n) - one of the cases where array list is better than linked list <br>
vi) Prepend and Remove first node are better with linked list than array list
<table>
 <thead>
  <tr>
   <th></th><th>Linked List</th><th>Array List</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td>Append</td><td>O(1)</td><td>O(1)</td>
  </tr>
  <tr>
   <td>Remove last</td><td>O(n)</td><td>O(1)</td>
  </tr>
  <tr>
   <td>Prepend</td><td>O(1)</td><td>O(n)</td>
  </tr>
  <tr>
   <td>Remove First</td><td>O(1)</td><td>O(n)</td>
  </tr>
  <tr>
   <td>Insert</td><td>O(n)</td><td>O(n)</td>
  </tr>
  <tr>
   <td>Remove</td><td>O(n)</td><td>O(n)</td>
  </tr>
  <tr>
   <td>Lookup by Index</td><td>O(n)</td><td>O(1)</td>
  </tr>
  <tr>
   <td>Lookup by Value</td><td>O(n)</td></td><td>O(n)</td>
  </tr>
 </tbody>
</table>

## Linked List under the hood
When we set something equal to a hashmap, the variable is just pointing to the hashmap.

## Linked List Constructor
```java
public class LinkedList {
	public LinkedList(int value) {...}
	// create new Node
	public void append(int value) {...}
	// create new Node
	// add Node to end
	public void prepend(int value) {...}
	// create new Node
	// add Node to beginning
	public boolean insert(int index, int value) {...}
	// create new Node
	// insert Node somewhere in the middle at a particular index
}
```
```java
class Node {
	int value;
	Node next; // variable of type node, it is a pointer to a node

	Node(int value) {  // constructor - passing the node a value, value here is the same as the rhs assignment of value below.
		this.value = value; // value from this.value refers to the variable of int data type declared in class Node above
	}
}
```
```java
public class LinkedList {
	private Node head; // type Node means they can point to a node
	private Node tail;
	private int length;  // keeping track of the length of the linked list, best practice to make class variables private
}
