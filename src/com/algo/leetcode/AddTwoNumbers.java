package com.algo.leetcode;

public class AddTwoNumbers {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
	public static void main(String[] args) {
		//Load first list
		ListNode l1 = new ListNode(8);
		ListNode four = new ListNode(4);
	//	ListNode three = new ListNode(3);
		l1.next = four;
		four.next = null;
	//	three.next = null;
		print(l1);
		//Load second list
		ListNode l2 = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode fourtwo = new ListNode(9);
		l2.next = six;
		six.next = fourtwo;
		fourtwo.next = null;
		System.out.println();
		print(l2);
		ListNode l3 = addTwoNumbers(l1, l2);
		System.out.println();
		print(l3);
		
		ListNode head = new ListNode(0);
		addTwoNumbersRecursive(l1, l2, 0, head);
		System.out.println();
		print(head.next);
	}
	
	private static void print(ListNode l3) {
		ListNode current = l3;
		while(current != null) {
			System.out.print(current.val);
			if(current.next != null) {
				System.out.print("->");
			}
			current = current.next;
		}
	}
	
	private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carryOn = 0;
		ListNode head = new ListNode(0);
		ListNode current = head;
		ListNode p = l1; ListNode q = l2;
		while(p != null || q != null) {
			int x = p != null? p.val:0;
			int y = q != null? q.val:0;
			int sum = x + y + carryOn;
			carryOn = sum/10;
			current.next = new ListNode(sum%10);
			current = current.next;
			if(p != null) p = p.next;
			if(q != null) q = q.next;
		}
		if(carryOn > 0) {
			current.next = new ListNode(carryOn);
			current = current.next;
		}
		current.next = null;
		return head.next;
    }
	
	public static void addTwoNumbersRecursive(ListNode l1, ListNode l2, int carryOn, ListNode head) {
		ListNode current = head;
		int x = l1 != null? l1.val:0;
		int y = l2 != null? l2.val:0;
		int sum = x + y + carryOn;
		carryOn = sum/10;	
		current.next = new ListNode(sum%10);
		current = current.next;
		if(l1 != null) l1 = l1.next;
		if(l2 != null) l2 = l2.next;		
		if(l2 == null && l1 == null && carryOn >0) {
			current.next = new ListNode(carryOn);
			current = current.next;
			current.next = null;
			return;
		}
		if(l2 == null && l1 == null) {
			current.next = null;
			return;
		}
		addTwoNumbersRecursive(l1, l2, carryOn, current);
		
	}
}
