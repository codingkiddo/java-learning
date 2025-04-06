package com.example.ds.linkedlist;

import com.example.ds.Node;

public class NthNodeFromTheEndOfALinkedList {
	static int findNthFromLast(Node head, int N) {
        int len = 0, i;
      
        // Pointer to store the copy of head
        Node temp = head;

        // Count the number of nodes in Linked List
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        // Check if value of N is not more than length of the linked list
        if (len < N)
            return -1;

        temp = head;

        // Get the (len - N + 1)th node from the beginning
        for (i = 1; i < len - N + 1; i++)
            temp = temp.next;

        return temp.data;
    }

    public static void main(String[] args) {
      
        // Create a hard-coded linked list:
        // 35 -> 15 -> 4 -> 20
        Node head = new Node(35);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        // Function Call to find the 4th node from end
        System.out.println(findNthFromLast(head, 4));
    }

}
