package com.algos.geeks;

import com.algos.geeks.MergeTwoLL.ListNode;

import edu.princeton.cs.algs4.StdRandom;

public class RandamNodeLL {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		ListNode four = new ListNode(11);
		ListNode three = new ListNode(23);
		ListNode five = new ListNode(29);
		ListNode seven = new ListNode(33);
		l1.next = four;
		four.next = three;
		three.next = five;
		five.next = seven;
		seven.next = null;
		print(l1);
		selectRandomNode(l1);
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
	
	
	public static void selectRandomNode(ListNode ll) {
		ListNode curr = ll;
		int rand = StdRandom.uniform(1, 6);
		int i=1;
		while(curr != null) {
			if(i == rand) {System.out.println(curr.val); break;}
			curr = curr.next;
			i++;
		}
	}

}
