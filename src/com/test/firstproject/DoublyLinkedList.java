package com.test.firstproject;

public class DoublyLinkedList {
	
	Node head;
	
	public class Node{
		Node prev;
		Node next;
		int val;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	public void push(int val) {
		if(head == null) {
			head = new Node(val);
			head.prev = null;
			head.next = null;
		}else {
			Node temp = head;
			head = new Node(val);
			head.prev = null;
			head.next = temp;
			temp.prev = head;
			temp.next = null;
		}
	}
	
	public static void main(String[] args) {
		
	}

}
