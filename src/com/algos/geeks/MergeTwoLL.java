package com.algos.geeks;

import java.util.LinkedList;

public class MergeTwoLL {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
	//Load first list
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
	//Load second list
		ListNode l2 = new ListNode(5);
		ListNode six = new ListNode(15);
		ListNode fourtwo = new ListNode(28);
		l2.next = six;
		six.next = fourtwo;
		fourtwo.next = null;
		print(l2);	
		System.out.println(mergeTwoLL(l1, l2).toString());
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
	
	public static LinkedList<Integer> mergeTwoLL(ListNode list1, ListNode list2) {
		ListNode curr1 = list1;
		ListNode curr2 = list2;
		LinkedList<Integer> newList = new LinkedList<Integer>();
		while(curr1 != null && curr2 != null) {
			newList.add(curr1.val);
			newList.add(curr2.val);
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		ListNode temp = null; 
		if(curr1 != null) temp = curr1;
		else if(curr2 != null) temp = curr2;
		
		if(temp != null) {
			while(temp != null) {
				newList.add(temp.val);
				temp = temp.next;
			}
		}
		return newList;
	}

}
