package com.interview.geeksforgeeks.linkedlist;

class Node {
    int data;
    Node next;
}

class LinkedList {
	Node head; // head of list
	 
    // Given a reference (pointer to pointer)
    // to the head of a list and an int, inserts
    // a new node on the front of the list.
    void insertAtFront(int new_data) {
		// 1. allocate node
        Node new_node = new Node();
 
        // 2. put in the data
        new_node.data = new_data;
 
        // 3. Make next of new node as head
        new_node.next = head;
 
        // 4. move the head to point
        // to the new node
        head = new_node;
	}
    
    /* This function is in LinkedList class.
    Inserts a new node after the given prev_node. This method is
    defined inside LinkedList class shown above */
    public void insertAfter(Node prev_node, int new_data) {
    	/* 1. Check if the given Node is null */
        if (prev_node == null) {
            System.out.println(
                "The given previous node cannot be null");
            return;
        }
        
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }
    
    void printList() {
    	
    	Node node = head;
    	
    	while ( node != null) {
    		System.out.print(node.data + " ");
    		node = node.next;
    	}
    }
}

public class LinkedListMain {

	public static void main(String[] args) {

		// Start with the empty list
        LinkedList list = new LinkedList();
 
        list.insertAtFront(6);
        list.insertAtFront(5);
        list.insertAtFront(4);
        list.insertAtFront(3);
        list.insertAtFront(2);
        list.insertAtFront(1);
 
        System.out.print(
            "After inserting nodes at their front: ");
        list.printList();
		
	}

}
