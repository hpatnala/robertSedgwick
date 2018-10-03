//Implement queue using linked list
package com.test.firstproject;

public class QueueLinkedList {
	public Node first = null;
	public Node last = null;
	public class Node{
		public int item;
		public Node next;
		
		public Node(int input) {
			item = input;
		}
	}
	
	public static void main(String[] args) {
		QueueLinkedList qll = new QueueLinkedList();
		qll.enqueue(1);
		qll.enqueue(3);
		qll.enqueue(2);
		qll.enqueue(3);
	//	System.out.println(qll.dequeue());
	//	System.out.println(qll.dequeue());
		qll.enqueue(3);
		qll.enqueue(1);
	//	System.out.println(qll.dequeue());
	//	System.out.println(qll.dequeue());
	//	System.out.println(qll.dequeue());
	//	System.out.println(qll.dequeue());
		Node current = qll.first;
		Node last = qll.first;
		boolean isPalindrom = false;
		System.out.println(qll.palindrome(current, last, isPalindrom));
		System.out.println(isPalindrom);
	}
	
	public boolean palindrome(Node currFirst, Node lastNode, boolean isPalindrom) {
		if(lastNode == null || currFirst == null) {
			return false;
		}
		palindrome(currFirst, lastNode.next, isPalindrom);
		if(currFirst.item == lastNode.item) {
			currFirst =  currFirst.next;
			return true;
		}
		else if(currFirst.item != lastNode.item) {
			return false;
		}
		return false;
	}
	
	public void enqueue(int a) {
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
