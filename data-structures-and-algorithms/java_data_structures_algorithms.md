# Linked List
public class LinkedList {
	public LinkedList(int value) {...}
	public void append(int value) {...} // append an item to the end of the linked list
	public Node removeLast() {...} // remove the last item
	public void prepend(int value) {...} // prepend an item
	public boolean insert(int index, int value) {...} // insert an item somewhere in the middle
	public Node remove(int index) {...} // remove an item
}

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
