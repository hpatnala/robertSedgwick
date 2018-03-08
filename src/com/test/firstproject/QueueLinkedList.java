//Implement queue using linked list
package com.test.firstproject;

public class QueueLinkedList {
	Node first = null;
	Node last = null;
	public class Node{
		int item;
		Node next;
		
		public Node(int input) {
			item = input;
		}
	}
	
	public static void main(String[] args) {
		QueueLinkedList qll = new QueueLinkedList();
		qll.enqueue(1);
		qll.enqueue(3);
		qll.enqueue(2);
		qll.enqueue(7);
		System.out.println(qll.dequeue());
		System.out.println(qll.dequeue());
		qll.enqueue(8);
		qll.enqueue(6);
		System.out.println(qll.dequeue());
		System.out.println(qll.dequeue());
		System.out.println(qll.dequeue());
		System.out.println(qll.dequeue());
	}
	
	private void enqueue(int a) {
		if(first == null) {
			first = new Node(a);
			first.next = null;
			last = first;
		}else {
			Node oldLast = new Node(a);
			last.next = oldLast;
			oldLast.next = null;	
			last = oldLast;
		}
	}
	
	private int dequeue() {
		if(first != null) {
			int item1 = first.item;
			first = first.next;
			return item1;
		}else {
			return 0;
		}
	}
}
