//Implement Iterator - hasNext() and next()
package com.test.firstproject;

import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterator{
	
	private Node first= null;
	
	public class Node{
		String item;
		Node next;
	}
	
	public static void main(String[] args) {
		ListIterator list = new ListIterator();
		list.hasNext();
		list.next();
	}

	@Override
	public boolean hasNext() {	
		return first == null;
	}

	@Override
	public Object next() {	
		String item1 = first.item;
		first = first.next;
		return item1;
	}
	
}
