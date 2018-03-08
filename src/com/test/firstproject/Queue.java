//Implement queue using an array - resizing of array (tricky)
package com.test.firstproject;

public class Queue {
	
	int[] a = new int[4];
	int[] b;
	int count = 0;
	int first =0;
	int last = 0;
	int reverseCount = 0;
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(3);
		q.enqueue(2);
		q.enqueue(1);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
	
	private void enqueue(int input) {
		if(count >  a.length-1 && (last - first != a.length -1)) {
			last = reverseCount;
			a[reverseCount++] = input;
		}
		if(count > a.length-1) {
			b = new int[2 * a.length];
			for(int i=0;i <a.length; i++) {
				b[i] = a[i];
			}
			b[count++] = input;
			last = count;
		}else
			a[count++] = input;
		
	}
	
	private int dequeue() {
		if(first < a.length) {
			return a[first++];
		}else if(first > a.length && first < b.length){
			return b[first++];
		}else if(last < first && first == a.length-1){
			return a[last--];
		}
		return 0;
	}

}
