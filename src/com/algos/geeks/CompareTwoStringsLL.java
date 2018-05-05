package com.algos.geeks;

import com.algo.leetcode.AddTwoNumbers.ListNode;

public class CompareTwoStringsLL {
	
	public static class ListNode {
		char val;
		ListNode next;
		ListNode(char x) { val = x; }
	}
	public static void main(String[] args) {
	//Load first list
		ListNode l1 = new ListNode('g');
		ListNode four = new ListNode('e');
		ListNode three = new ListNode('e');
		l1.next = four;
		four.next = three;
		three.next = null;
		print(l1);	
	//Load second list
		ListNode l2 = new ListNode('g');
		ListNode six = new ListNode('e');
		ListNode fourtwo = new ListNode('k');
		l2.next = six;
		six.next = fourtwo;
		fourtwo.next = null;
		print(l2);	
		System.out.println("The two lists are equal: " + compareTwoStringsLL(l1, l2));
	}
	
	public static void print(ListNode ll) {
		ListNode curr = ll;
		while(curr != null) {
			System.out.print(curr.val);
			curr = curr.next;
		}
		System.out.println();
	}
	
	public static boolean compareTwoStringsLL(ListNode list1, ListNode list2){
		ListNode curr1 = list1;
		ListNode curr2 = list2;
		boolean isEqual = false;
		while(curr1 != null && curr2 != null) {
			if(curr1.val == curr2.val) {
				isEqual = true;
			}
			else {
				isEqual = false;
				break;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}		
		if(isEqual == true && (curr1 !=null || curr2 != null)) return false;	
		return isEqual;
	}
	
	public boolean comp2StrngsRec(ListNode curr1, ListNode curr2, boolean isEqual){
	//	if(curr1 == null || curr2 == null) return;
			
		if(isEqual == true && (curr1 !=null || curr2 != null)) return false;	
		return isEqual;
	}

}
