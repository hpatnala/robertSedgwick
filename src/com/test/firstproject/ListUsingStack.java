//Implement List - using Stack and queue
package com.test.firstproject;

public class ListUsingStack {
	int[] list = new int[5];
	int[] list1;
	int count = 0;
	int first =0;
	
	public static void main(String[] args) {
		ListUsingStack listImpl = new ListUsingStack();
		
		System.out.println("isEmpty: " + listImpl.isEmpty());
		
		listImpl.add(3);
		listImpl.add(5);
		listImpl.add(6);
		listImpl.add(8);
		listImpl.add(7);
		listImpl.add(2);
		listImpl.add(4);
		listImpl.add(1);
		listImpl.add(9);
		
		System.out.println("Pop: " + listImpl.print());
		System.out.println("Dequeue: " + listImpl.dequeue());
		System.out.println("contains: " + listImpl.contains(4));
		System.out.println("getIndex: " + listImpl.getIndex(5));
		
	}
	
	private boolean isEmpty() {
		return list.length > 0;
	}
	
	private int getIndex(int i) {
		if(count < list.length-1) {
			return list[i];
		}else {
			return list1[i];
		}
	}
	
	private boolean contains(int input) {
		int[] tempList;
		if(count < list.length) {
			tempList = list;
		}else {
			tempList = list1;
		}
		for(Integer a : tempList) {
			if(a == input) {
				return true;
			}
		}
		return false;
	}
	
	//serves as push and enqueue
	private void add(int input) { 
		if(count > list.length - 1) {
			if(count == list.length) {
				list1 = new int[2 * list.length];
				int j=0;
				for(Integer a : list) {
					list1[j] = a;
					j++;
				}	
				list1[count++] = input;
			}else {
				list1[count++] = input;
			}		
		}else {
			list[count++] = input;
		}
	}
	
	//serves as pop
	private int print() {
		if(count > list.length) {
			return list1[--count];
		}else {
			return list[--count];
		}
	}
	
	//serves as dequeue
	private int dequeue() {
		if(count < list.length){
			return list[first++];
		}else {
			return list1[first++];
		}
	}
}
