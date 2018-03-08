//Implement stack using an array - resizing of array
package com.test.firstproject;

public class Stack {
	private int array[] = new int[4];
	int newArray[];
	int popArray[];
	private int count=0;
	
	public static void main(String[] args) {	
		Stack stack = new Stack();
		stack.push(2);
		stack.push(6);
		stack.push(5);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
	public void push(int a){
		if(count > array.length-1){
			if(count == array.length) {
				newArray = new int[2 * array.length];
				int i=0;
				for(Integer ar : array) {
					newArray[i++] = ar;
				}
				newArray[count] = a;
				count=count + 1;
			}else {
				newArray[count] = a;
				count=count + 1;
			}
		}else {
			array[count++] = a;
		}
	}
	
	public int pop() {
		int item = 0;
		if(count>0 && count < array.length) {
			item = array[--count];
			if(count == (array.length/2 -1)) {
				newArray = new int[array.length/2];
				int i=0;
				for(Integer ar : array) {
					if(i == newArray.length)
						break;
					newArray[i++] = ar;
				}
			}
		}
		if(count>array.length -1 && count < newArray.length) {
			item = newArray[--count];
			if(count == (newArray.length/2 -1)) {	
				newArray = new int[newArray.length/2];
				int i=0;
				for(Integer ar : array) {
					if(i == newArray.length)
						break;
					newArray[i++] = ar;
				}
			}
		}
		return item;
	}

}
