package com.algos.geeks;

import java.util.LinkedList;
import com.algos.geeks.MergeTwoLL.ListNode;
import edu.princeton.cs.algs4.Stack;

public class ReverseLLInGrps {

	public static void main(String[] args) {
	//Load first list
		ListNode l1 = new ListNode(3);
		ListNode four = new ListNode(11);
		ListNode three = new ListNode(23);
		ListNode five = new ListNode(29);
		ListNode seven = new ListNode(33);
		ListNode l2 = new ListNode(5);
		ListNode six = new ListNode(15);
		ListNode fourtwo = new ListNode(28);
		l1.next = four;
		four.next = three;
		three.next = five;
		five.next = seven;
		seven.next = l2;	
		l2.next = six;
		six.next = fourtwo;
		fourtwo.next = null;
		print(l1);	
		System.out.println(reverseLL(l1, 3).toString());
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
	
	public static LinkedList<Integer> reverseLL(ListNode list1, int k) {
		ListNode curr = list1;
		int i = 1;
		Stack<Integer> stack = new Stack<Integer>();
		LinkedList<Integer> newList = new LinkedList<Integer>();
		while(curr != null) {
			if(i < k) {
				stack.push(curr.val);
			}
			if(i==k) {
				stack.push(curr.val);
				while(!stack.isEmpty()) {
					newList.add(stack.pop());
				}
				i=0;
			}	
			i++;
			curr = curr.next;
		}
		
		while(!stack.isEmpty()) {
			newList.add(stack.pop());
		}
		
		return newList;
	}

}
