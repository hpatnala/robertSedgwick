package com.robertSedgewick.assignment;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
	
	private Node head = null;	
	private Node tail = null;	
	private Node firstAdded = null;
	private int countOfObjects;
	
	public Deque() {
		countOfObjects = 0;
	}
	
	 private class Node{
		Item item;
		Node next;
		Node previous;
		
		public Node(Item input) {
			item = input;
		}
	}
	
	 @SuppressWarnings("hiding")
	private class DequeIterator<Item> implements Iterator<Item>{
		
		 public boolean hasNext() {
			
			 return head != null;
		 }
		 
		 @SuppressWarnings("unchecked")
		public Item next() {
		
			 if(head == null) {
				 throw new java.util.NoSuchElementException();
			 }	 
			 Item temp = (Item) head.item;		 	 
			 head = head.next;		 
			 return temp;
		 }
	 }
	 
	public static void main(String[] args) {
		Deque<String> deque = new Deque<String>();
		deque.addFirst("First");
		deque.addFirst("Second");
		deque.addLast("LThird");
		deque.addLast("LFourth");
		deque.addFirst("Fifth");
		deque.addFirst("Sixth");
		
		System.out.println("remove first: "+deque.removeFirst());
		System.out.println("remove last: "+deque.removeLast());
		System.out.println("remove last: "+deque.removeLast());
		System.out.println("remove first: "+deque.removeFirst());
		System.out.println("remove last: "+deque.removeLast());
		

		
		Iterator<String> iterator = deque.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}	
	}
	
	public boolean isEmpty() {
		return countOfObjects > 0;
	}
	
	public int size() {
		return countOfObjects;
	}
	
	@Override
	public Iterator<Item> iterator() {	
		return new DequeIterator<Item>();
	}
	
	public void addFirst(Item item) {
		if(item == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		if(head == null) {
			Node input = new Node(item);
			head = input;
			head.next = null;
			countOfObjects++;
			//tracking the current, tail
			tail = head;
			firstAdded = head;
		}else{
			Node input = new Node(item);
			Node temp = head;
			head = input;
			head.next = temp;
			countOfObjects++;
			if(head == tail) {
				tail = head.next;
				firstAdded.previous = head;
			}	
			 
		}
	}
	
	public void addLast(Item item) {
		if(item == null) {
			throw new java.lang.IllegalArgumentException();
		}
		
		if(head == null) {
			Node input = new Node(item);
			head = input;
			input.next = null;
			countOfObjects++;
			//tracking the current, tail	
			tail = head;
		}else{
			Node input = new Node(item);
			Node tempTail = tail;
			tail = input;
			tempTail.next = tail;
			tail.previous = tempTail;
			countOfObjects++;
		}
	}
	
	public Item removeFirst() {
		if(head == null) {
			throw new java.util.NoSuchElementException();
		}
		
		Node temp = null;
		if(head != null) {
			temp = head;
			head = head.next;
		}
		return temp.item;
	}
	
	public Item removeLast() {
		Node temp = null;	
		if(tail == null) {
			throw new java.util.NoSuchElementException();
		}	
	
		if(tail != null) {
			temp = tail;
			if(tail.previous != null) {
				tail = tail.previous;
			}		
			tail.next = null;
		}
		return temp.item;
	}
}
