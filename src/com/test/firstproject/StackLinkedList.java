//Implement stack using linked list
package com.test.firstproject;

public class StackLinkedList {
	private Node first = null;
	
	 public class Node{
		 int item;
		 Node next;
		 
		 public Node(int input){
			 item = input;
		 }
	 }
	
	public static void main(String[] args) {
		StackLinkedList sll = new StackLinkedList();
		sll.push(4);
		sll.push(8);
		sll.push(6);
		sll.push(9);
		sll.push(1);
		sll.push(3);
		sll.push(2);
		sll.push(7);
		System.out.println(sll.pop());
		System.out.println(sll.peek());
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	private void push(int a) {
		Node oldFirst = first;
		first = new Node(a);
		first.next = oldFirst;
	}
	
	private int pop() {
		if(first != null) {
			int item1 = first.item;
			first = first.next;
			return item1;
		}else {
			return 0;
		}
	}
	
	private int peek() {
		if(first != null) {
			return first.item;
		}else {
			return 0;
		}
	}

}
