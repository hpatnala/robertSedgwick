package com.algos.geeks;

import com.algos.geeks.MergeTwoLL.ListNode;

public class DetectAndRemoveLoop {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		l1.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = two;
		System.out.println(detectLoop(l1));
		print(l1);	
	}
	
	public static void print(ListNode ll) {
		ListNode curr = ll;
		while(curr != null) {
			System.out.print(curr.val);
			System.out.print(",");
			curr = curr.next;
		}
		System.out.println();
	}
	
	public static boolean detectLoop(ListNode ll) {
		ListNode slowPointer = ll; ListNode fastPointer = ll;	
		while(fastPointer != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next != null?fastPointer.next.next:fastPointer.next;
			if(fastPointer == slowPointer) {slowPointer.next = null; return true;}
		}		
		return false;
	}
}
