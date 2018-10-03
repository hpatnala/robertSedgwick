package com.algo.leetcode;

import com.test.firstproject.QueueLinkedList;
import com.test.firstproject.QueueLinkedList.Node;

public class MiddleNode {
	
	public static int middleNode(Node head) {
		if(head == null) {
			throw new NullPointerException("Please add the nodes to the list");
		}
		Node current = head;
		Node next = null;
		if(current.next != null)
			next = current.next.next;
		while(next != null && next.next != null) {
			current = current.next;	
			next = next.next.next;
		}	
		if(current.next != null)
			return current.next.item;
		else
			return current.item;
	}
	
	public static void main(String[] args) {
			QueueLinkedList qll = new QueueLinkedList();
			qll.enqueue(1);
			qll.enqueue(2);
			qll.enqueue(3);
			qll.enqueue(4);
			qll.enqueue(5);
			
			System.out.println(middleNode(qll.first));
	}

}
