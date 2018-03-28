package com.algo.leetcode;

public class AddTwoNumbers {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	
	public static void main(String[] args) {
		//Load first list
		ListNode l1 = new ListNode(2);
		ListNode four = new ListNode(4);
		ListNode three = new ListNode(3);
		l1.next = four;
		four.next = three;
		three.next = null;
		print(l1);
		//Load second list
		ListNode l2 = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode fourtwo = new ListNode(7);
		l2.next = six;
		six.next = fourtwo;
		fourtwo.next = null;
		System.out.println();
		print(l2);
		ListNode l3 = addTwoNumbers(l1, l2);
		System.out.println();
		print(l3);
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
}
